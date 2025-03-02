package chapters.seventeen.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FastTraversalLinkedListPerformance {
    static Random random = new Random();
    static int repeats = 1_000;

    static List<Test<FastTraversalLinkedList<Integer>>> tests =
            new ArrayList<>();
    static List<Test<FastTraversalLinkedList<Integer>>> qTests =
            new ArrayList<>();

    static {
        tests.add(new Test<FastTraversalLinkedList<Integer>>("add") {
            @Override
            int test(FastTraversalLinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < listSize; j++)
                        container.add(j);
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("get") {
            @Override
            int test(FastTraversalLinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops * repeats;
                int listSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.get(random.nextInt(listSize));
                return loops;
            }
        });

        qTests.add(new Test<FastTraversalLinkedList<Integer>>("addFirst") {
            @Override
            int test(FastTraversalLinkedList<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<FastTraversalLinkedList<Integer>> {
        public ListTester(FastTraversalLinkedList<Integer> container, List<Test<FastTraversalLinkedList<Integer>>> tests) {
            super(container, tests);
        }

        public static void run(FastTraversalLinkedList<Integer> list, List<Test<FastTraversalLinkedList<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
        Tester.fieldWidth = 16;
        Tester<FastTraversalLinkedList<Integer>> qTest =
                new Tester<FastTraversalLinkedList<Integer>>(new FastTraversalLinkedList<Integer>(), qTests);
        qTest.setHeadLine("Queue tests");
        qTest.timedTest();
    }
}
