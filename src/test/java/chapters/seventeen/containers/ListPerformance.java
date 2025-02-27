package chapters.seventeen.containers;

// Тестирование производительности операций
// при работе с List
// {Args: 100 500} Небольшие значения,
// чтобы тесты не занимали много времени

import chapters.containers.countries.Countries;
import chapters.containers.generators.CollectionData;
import chapters.containers.lightweight.CountingIntegerList;
import chapters.sixteen.arrays.generators.CountingGenerator;
import chapters.sixteen.arrays.generators.Generated;

import java.util.*;

public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<String>>> tests = new ArrayList<>();
    static List<Test<LinkedList<String>>> qTests = new ArrayList<>();

    static {
        // 1. Тестирование поведения списка (List)
        // add
        tests.add(new Test<List<String>>("add") {
            @Override
            int test(List<String> container, TestParam tp) {
                int loops = tp.loops;
                int containerSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < containerSize; j++)
                        container.add(String.valueOf(j));
                }

                return loops * containerSize;
            }
        });

        // get
        tests.add(new Test<List<String>>("get") {
            @Override
            int test(List<String> container, TestParam tp) {
                int loops = tp.loops * reps;
                int containerSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.get(rand.nextInt(containerSize));

                return loops;
            }
        });

        // set
        tests.add(new Test<List<String>>("set") {
            @Override
            int test(List<String> container, TestParam tp) {
                int loops = tp.loops * reps;
                int containerSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.set(rand.nextInt(containerSize), String.valueOf(47));

                return loops;
            }
        });

        // iter add
        tests.add(new Test<List<String>>("iteradd") {
            @Override
            int test(List<String> container, TestParam tp) {
                final int LOOPS = 1_000_000;
                int half = container.size() / 2;
                ListIterator<String> it = container.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add(String.valueOf(47));

                return LOOPS;
            }
        });

        // insert
        tests.add(new Test<List<String>>("insert") {
            @Override
            int test(List<String> container, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    container.add(5, String.valueOf(47)); // Минимизация затрат на произвольный доступ

                return loops;
            }
        });

//        tests.add(new Test<List<String>>("sort") {
//            @Override
//            int test(List<String> container, TestParam tp) {
//
//            }
//        });

        // remove
        tests.add(new Test<List<String>>("remove") {
            @Override
            int test(List<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while (container.size() > 5)
                        container.remove(5); // Минимизация затрат на произвольный доступ
                }

                return loops * size;
            }
        });

        // 2. Тестирование поведения очереди (LinkedList)
        // add first
        qTests.add(new Test<LinkedList<String>>("addFirst") {
            @Override
            int test(LinkedList<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++)
                        container.addFirst(String.valueOf(47));
                }

                return loops * size;
            }
        });

        // add last
        qTests.add(new Test<LinkedList<String>>("addLast") {
            @Override
            int test(LinkedList<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++)
                        container.addLast(String.valueOf(47));
                }

                return loops * size;
            }
        });

        // rm first
        qTests.add(new Test<LinkedList<String>>("rmFirst") {
            @Override
            int test(LinkedList<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while (container.size() > 0)
                        container.removeFirst();
                }
                return loops * size;
            }
        });

        // rm last
        qTests.add(new Test<LinkedList<String>>("rmLast") {
            @Override
            int test(LinkedList<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while (container.size() > 0)
                        container.removeLast();
                }

                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }

        // Заполняется до нужного размера перед каждым тестом
        @Override
        protected List<String> initialise(int size) {
            container.clear();
            container.addAll(CollectionData.list(new CountingGenerator.String(), size));

            return container;
        }

        // Вспомогательный метод
        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }

        public static void main(String[] args) {
            if (args.length > 0)
                Tester.defaultParams = TestParam.array(args);
            // Выполняет с массивом только эти два теста
            Tester<List<String>> arrayTest = new Tester<List<String>>(null, tests.subList(1, 3)) {

                // Будет вызываться перед каждым тестом. Создаёт список
                // на базе массивабез возмоджности изменения размера:
                @Override
                protected List<String> initialise(int size) {
                    String[] sa = Generated.array(String.class, new CountingGenerator.String(5), size);

                    return Arrays.asList(sa);
                }
            };

            arrayTest.setHeadLine("Arrays as List");
            arrayTest.timedTest();
            Tester.defaultParams = TestParam.array(
                    10, 5000, 100, 5000, 1000, 1000, 10000, 200);
            if (args.length > 0)
                Tester.defaultParams = TestParam.array(args);
            ListTester.run(new ArrayList<String>(), tests);
            ListTester.run(new LinkedList<String>(), tests);
            ListTester.run(new Vector<String>(), tests);

            Tester.fieldWidth = 12;
            Tester<LinkedList<String>> qTest = new Tester<LinkedList<String>>(new LinkedList<>(), qTests);
            qTest.setHeadLine("Queue tests");
            qTest.timedTest();
        }
    }
}
