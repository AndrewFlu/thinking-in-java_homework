package chapters.sixteen.arrays.comparing.pattern_strategy;

import chapters.sixteen.arrays.generators.Generated;

import java.util.Arrays;
import java.util.Collections;

import static net.mindview.utils.Print.print;

public class Reverse {
    public static void main(String[] args) {
        CompType[] compTypesArray = Generated.array(new CompType[10], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(compTypesArray));
        Arrays.sort(compTypesArray);
        print("after sorting:");
        print(Arrays.toString(compTypesArray));
        print("");
        Arrays.sort(compTypesArray, Collections.reverseOrder());
        print("after sorting with custom comparator (Collections.reverseOrder()):");
        print(Arrays.toString(compTypesArray));
    }
}
