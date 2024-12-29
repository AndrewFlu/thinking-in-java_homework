package chapters.sixteen.arrays.comparing.pattern_strategy;

import chapters.sixteen.arrays.generators.Generated;

import java.util.Arrays;

import static net.midview.Print.print;

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] compTypeArray = Generated.array(new CompType[7], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(compTypeArray));
        Arrays.sort(compTypeArray, new CompTypeComparator());
        print("after sorting with custom comparator (sort by j-field):");
        print(Arrays.toString(compTypeArray));
    }
}
