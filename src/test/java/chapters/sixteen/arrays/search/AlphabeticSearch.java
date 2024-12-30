package chapters.sixteen.arrays.search;

import chapters.sixteen.arrays.generators.Generated;
import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.Arrays;

public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] stringArray = Generated.array(new String[15], new RandomGenerator.String(5));
        System.out.println("before sorting: " + Arrays.toString(stringArray));
        Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);
        System.out.println("after sorting: " + Arrays.toString(stringArray));
        int index = Arrays.binarySearch(stringArray, stringArray[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: " + index + "\n" + stringArray[index]);
    }
}
