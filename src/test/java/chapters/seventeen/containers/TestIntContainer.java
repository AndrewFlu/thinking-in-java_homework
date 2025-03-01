package chapters.seventeen.containers;

import java.util.ArrayList;
import java.util.List;

public class TestIntContainer {
    static final int LOOPS = 10_000;
    static List<Test<List<Integer>>> arrayListTests = new ArrayList<>();
    static List<Test<IntContainer>> intContainerTests = new ArrayList<>();

    static {
        arrayListTests.add(new Test<List<Integer>>(" add | set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    container.add(i);
                    container.set(i, container.get(i) + 1);
                }
                return LOOPS;
            }
        });
        intContainerTests.add(new Test<IntContainer>(" add | set") {
            @Override
            int test(IntContainer container, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    container.add(i);
                    container.set(i, container.get(i) + 1);
                }

                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<>(LOOPS), arrayListTests);
        Tester.run(new IntContainer(LOOPS), intContainerTests);
    }
}
