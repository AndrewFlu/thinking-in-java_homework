package chapters.sixteen.arrays.comparing;

import java.util.Arrays;

import static net.midview.Print.print;

public class CustomObjectComparisonTestDrive {
    public static void main(String[] args) {
        CustomObject[] c1 = new CustomObject[5];
        CustomObject[] c2 = new CustomObject[5];
        Arrays.fill(c1, new CustomObject(15));
        Arrays.fill(c2, new CustomObject(15));

        print("c1 = " + Arrays.toString(c1));
        print("c2 = " + Arrays.toString(c2));
        print("c1 == c2: " + Arrays.equals(c1, c2));
    }
}
