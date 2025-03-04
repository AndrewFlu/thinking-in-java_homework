package chapters.seventeen.containers;

import chapters.eleven.containers.map.slowmap.CorrectedSlowMap;
import chapters.eleven.containers.map.slowmap.SlowMap;

import java.util.*;

public class SlowMapPerformance {

    static List<Test<SlowMap<Integer, Integer>>> tests =
            new ArrayList<>();

    static {
        tests.add(new Test<SlowMap<Integer, Integer>>("put") {
            @Override
            int test(SlowMap<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.put(j, j);
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<SlowMap<Integer, Integer>>("get") {
            @Override
            int test(SlowMap<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.get(j);
                    }
                }
                return loops * span;
            }
        });

        tests.add(new Test<SlowMap<Integer, Integer>>("iterate") {
            @Override
            int test(SlowMap<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, Integer>> iterator = container.entrySet().iterator();
                    while (iterator.hasNext())
                        iterator.next();
                }
                return loops * container.size();
            }

        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.run(new SlowMap<>(), tests);
        Tester.run(new CorrectedSlowMap<>(), tests);
    }
}
