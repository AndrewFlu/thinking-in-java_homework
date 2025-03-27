package chapters.sixteen.arrays.comparing;

import chapters.sixteen.arrays.generators.Generated;
import chapters.sixteen.arrays.generators.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

import static net.mindview.utils.Print.print;

public class StringComparisonTest {
    public static void main(String[] args) {
        String[] str = Generated.array(new String[10], new RandomGenerator.String());
        print("before sorting: " + Arrays.toString(str));

        Arrays.sort(str);
        print("lexicographical order sorting: " + Arrays.toString(str));

        Arrays.sort(str, Collections.reverseOrder());
        print("reverse sorting: " + Arrays.toString(str));

        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
        print("case insensitive order sorting: " + Arrays.toString(str));

    }
}
