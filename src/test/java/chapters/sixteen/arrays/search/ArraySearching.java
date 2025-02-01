package chapters.sixteen.arrays.search;

import chapters.sixteen.arrays.generators.Generated;
import chapters.sixteen.arrays.generators.RandomGenerator;
import chapters.sixteen.arrays.generators.converttoprimitives.ConvertTo;
import net.mindview.utils.Generator;

import java.util.Arrays;

import static net.midview.Print.print;

public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> generator = new RandomGenerator.Integer(1000);
        int[] intArray = ConvertTo.primitive(Generated.array(new Integer[25], generator));
        Arrays.sort(intArray);
        print("sorted array: " + Arrays.toString(intArray));

        while (true) {
            int randomNumberToSearch = generator.next();
            int resultIndex = Arrays.binarySearch(intArray, randomNumberToSearch);
            if (resultIndex >= 0) {
                System.out.printf("Location index of %s is %s, intArray[%s]", resultIndex, intArray[resultIndex], resultIndex);
                break;
            }
        }
    }
}
