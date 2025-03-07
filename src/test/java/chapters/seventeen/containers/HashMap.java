package chapters.seventeen.containers;

import chapters.containers.lightweight.CountingMapData;
import chapters.sixteen.arrays.generators.CountingGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMap {
    static List<Test<Map<Integer, String>>> tests = new ArrayList<>();
    static CountingGenerator.String cgs = new CountingGenerator.String(5);

    static {
        tests.add(new Test<Map<Integer, String>>("put") {
            @Override
            int test(Map<Integer, String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.put(j, cgs.next());
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<Map<Integer, String>>("get") {
            @Override
            int test(Map<Integer, String> container, TestParam tp) {
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

        tests.add(new Test<Map<Integer, String>>("iterate") {
            @Override
            int test(Map<Integer, String> container, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, String>> iterator = container.entrySet().iterator();
                    while (iterator.hasNext())
                        iterator.next();
                }
                return loops * container.size();
            }

        });
    }

    public static void main(String[] args) {
        java.util.HashMap<Integer, String> map1 = new java.util.HashMap<>();
        System.out.println("map1: " + map1);
        map1.putAll(new CountingMapData(16));
        System.out.println("map1: " + map1);
        java.util.HashMap<Integer, String> map2 = new java.util.HashMap<>(64);
        System.out.println("map2: " + map2);
        map2.putAll(map1);
        System.out.println("map2: " + map2);
        java.util.HashMap<Integer, String> map3 = new java.util.HashMap<>(1028);
        System.out.println("map3: " + map3);
        map3.putAll(map1);
        System.out.println("map3: " + map3);

        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        else
            Tester.defaultParams = TestParam.array(10, 1000, 100, 1000, 1000, 1000);

        System.out.println("Comparing time test:");
        Tester.run(map1, tests);
        Tester.run(map2, tests);
        Tester.run(map3, tests);

    }
}
