package chapters.sixteen.arrays.search;

import chapters.sixteen.arrays.generators.Generated;
import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.Arrays;

public class SearchingInUnsortedArray {
    public static void main(String[] args) {
        String[] unsorted = Generated.array(new String[10], new RandomGenerator.String(3));
        System.out.println("before search: " + Arrays.toString(unsorted));
        String search = unsorted[4];
        int i = Arrays.binarySearch(unsorted, search);
        System.out.println("The search string is '" + search + "'");
        System.out.println("Found index is " + i);
    }
}
