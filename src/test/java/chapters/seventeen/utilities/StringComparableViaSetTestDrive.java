package chapters.seventeen.utilities;

import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.*;

public class StringComparableViaSetTestDrive {
    public static void main(String[] args) {
        RandomGenerator.String randomStringGenerator = new RandomGenerator.String(7);
        RandomGenerator.Integer randomIntegerGenerator = new RandomGenerator.Integer(100);

        Set<ComparableTwoStrings> set = new HashSet<>();
        Map<ComparableTwoStrings, Integer> map = new HashMap<>();

        // fill containers
        for (int i = 0; i < 4; i++) {
            String s1 = randomStringGenerator.next();
            String s2 = randomStringGenerator.next();
            set.add(new ComparableTwoStrings(s1, s2));
            map.put(new ComparableTwoStrings(s1, s2), randomIntegerGenerator.next());
        }
        System.out.println("set: " + set);
        System.out.println("map: " + map);
        System.out.println("map.keySet(): " + map.keySet());

        System.out.println("sorted by first string: ");
        Set<ComparableTwoStrings> treeSet = new TreeSet<>(set);
        System.out.println("treeSet: " + treeSet);
        Map<ComparableTwoStrings, Integer> treeMap = new TreeMap<>(map);
        System.out.println("treeMap: " + treeMap);

        System.out.println("sorted by second string:");
        Comparator<? super ComparableTwoStrings> comparator = ComparableTwoStrings.SECOND_COMPARATOR;
        Set<ComparableTwoStrings> treeSet2 = new TreeSet<>(comparator);
        treeSet2.addAll(treeSet);
        System.out.println("treeSet2: " + treeSet2);
        Map<ComparableTwoStrings, Integer> treeMap2 = new TreeMap<>(comparator);
        treeMap2.putAll(treeMap);
        System.out.println("treeMap2: " + treeMap2);
    }
}
