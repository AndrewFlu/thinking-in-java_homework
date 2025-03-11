package chapters.seventeen.utilities;

import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringComparableTestDrive {
    public static void main(String[] args) {
        RandomGenerator.String randomStringGenerator = new RandomGenerator.String(7);
        ComparableTwoStrings[] array = new ComparableTwoStrings[5];
        List<ComparableTwoStrings> list = new ArrayList<>();
        // fill containers
        for (int i = 0; i < array.length; i++) {
            String s1 = randomStringGenerator.next();
            String s2 = randomStringGenerator.next();
            array[i] = new ComparableTwoStrings(s1, s2);
            list.add(new ComparableTwoStrings(s1, s2));
        }

        System.out.println("array: " + Arrays.toString(array));
        System.out.println("list: " + list);
        System.out.println();

        System.out.println("before sorting: ");
        ComparableTwoStrings key = list.get(1);
        System.out.println("finding key: " + key);
        int i = Collections.binarySearch(list, key);
        System.out.println("found key in index: " + i);
        System.out.println();

        Collections.sort(list);
        System.out.println("after sorting (first comparator): ");
        System.out.println("sorted list: " + list);
        key = list.get(1);
        System.out.println("finding key: " + key);
        i = Collections.binarySearch(list, key);
        System.out.println("found key in index: " + i);
        System.out.println();

        System.out.println("sorting with second comparator...");

        Collections.sort(list, ComparableTwoStrings.SECOND_COMPARATOR);
        System.out.println("sorted list: " + list);
        key = list.get(1);
        System.out.println("finding key: " + key);
        i = Collections.binarySearch(list, key);
        System.out.println("found key in index: " + i);
        System.out.println();
    }
}
