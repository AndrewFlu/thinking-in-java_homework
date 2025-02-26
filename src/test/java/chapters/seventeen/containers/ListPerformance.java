package chapters.seventeen.containers;

// Тестирование производительности операций
// при работе с List
// {Args: 100 500} Небольшие значения,
// чтобы тесты не занимали много времени

import chapters.containers.lightweight.CountingIntegerList;
import chapters.sixteen.arrays.generators.CountingGenerator;
import chapters.sixteen.arrays.generators.Generated;

import java.util.*;

public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();

    static {
        // 1. Тестирование поведения списка (List)
        // add
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int containerSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < containerSize; j++)
                        container.add(j);
                }

                return loops * containerSize;
            }
        });

        // get
        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int containerSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.get(rand.nextInt(containerSize));

                return loops;
            }
        });

        // set
        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int containerSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.set(rand.nextInt(containerSize), 47);

                return loops;
            }
        });

        // iter add
        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                final int LOOPS = 1_000_000;
                int half = container.size() / 2;
                ListIterator<Integer> it = container.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add(47);

                return LOOPS;
            }
        });

        // insert
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    container.add(5, 47); // Минимизация затрат на произвольный доступ

                return loops;
            }
        });


        // remove
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = container.size();
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size() > 5)
                        container.remove(5); // Минимизация затрат на произвольный доступ
                }

                return loops * size;
            }
        });

        // 2. Тестирование поведения очереди (LinkedList)
        // add first
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++)
                        container.addFirst(47);
                }

                return loops * size;
            }
        });

        // add last
        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++)
                        container.addLast(47);
                }

                return loops * size;
            }
        });

        // rm first
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size() > 0)
                        container.removeFirst();
                }
                return loops * size;
            }
        });

        // rm last
        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size() > 0)
                        container.removeLast();
                }

                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        // Заполняется до нужного размера перед каждым тестом
        @Override
        protected List<Integer> initialise(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));

            return container;
        }

        // Вспомогательный метод
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }

        public static void main(String[] args) {
            if (args.length > 0)
                Tester.defaultParams = TestParam.array(args);
            // Выполняет с массивом только эти два теста
            Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)) {

                // Будет вызываться перед каждым тестом. Создаёт список
                // на базе массивабез возмоджности изменения размера:
                @Override
                protected List<Integer> initialise(int size) {
                    Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);

                    return Arrays.asList(ia);
                }
            };

            arrayTest.setHeadLine("Arrays as List");
            arrayTest.timedTest();
            Tester.defaultParams = TestParam.array(
                    10, 5000, 100, 5000, 1000, 1000, 10000, 200);
            if (args.length > 0)
                Tester.defaultParams = TestParam.array(args);
            ListTester.run(new ArrayList<Integer>(), tests);
            ListTester.run(new LinkedList<Integer>(), tests);
            ListTester.run(new Vector<Integer>(), tests);

            Tester.fieldWidth = 12;
            Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<>(), qTests);
            qTest.setHeadLine("Queue tests");
            qTest.timedTest();
        }
    }
}
