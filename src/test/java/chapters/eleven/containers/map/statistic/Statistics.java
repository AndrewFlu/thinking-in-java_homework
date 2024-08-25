package chapters.eleven.containers.map.statistic;

import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();

        computeFrequency(random, m);
        Set<Integer> treeSet = new TreeSet<>(m.values());

        LinkedHashMap<Integer, Integer> sortedByValuesMap = MapUtils.getSortedByValuesMap(m);

        System.out.println(m);
        System.out.println(treeSet);
        System.out.println(sortedByValuesMap);

        Map.Entry<Integer, Integer> lastEntry = sortedByValuesMap.lastEntry();
        System.out.println("Чаще всего встречается число: " + lastEntry.getKey());
        System.out.println("Количество его генераций = " + lastEntry.getValue());

    }

    private static void computeFrequency(Random random, Map<Integer, Integer> m) {
        for (int i = 0; i < 10_000; i++) {
            int r = random.nextInt(20);
            m.compute(r, (k, frequency) -> frequency == null ? 1 : frequency + 1);
        }
    }
}
