package chapters.sixteen.arrays.comparing;

import java.util.Arrays;

import static net.midview.Print.print;

public class DeepEqualsTestDrive {
    public static void main(String[] args) {
        int[][] i1 = new int[2][5];
        for (int[] ints : i1) {
            Arrays.fill(ints, 7);
        }
        print("i1[][] = " + Arrays.deepToString(i1));
        int[][] i2 = {
                {7, 7, 7, 7, 7},
                {7, 7, 7, 7, 7},
        };
        print("i2[][] = " + Arrays.deepToString(i2));

        print("i1 == i2 : " + Arrays.deepEquals(i1, i2));
    }
}
