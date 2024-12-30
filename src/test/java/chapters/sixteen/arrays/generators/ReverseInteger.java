package chapters.sixteen.arrays.generators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ReverseInteger {
    public static void main(String[] args) {
        Integer[] integers = Generated.array(new Integer[7], new RandomGenerator.Integer());
        System.out.println("initial array: " + Arrays.toString(integers));
        Arrays.sort(integers, Comparator.reverseOrder());

        System.out.println("reversed array: " + Arrays.toString(integers));
    }
}
