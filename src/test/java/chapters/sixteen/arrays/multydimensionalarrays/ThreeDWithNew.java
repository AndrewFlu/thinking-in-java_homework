package chapters.sixteen.arrays.multydimensionalarrays;

import java.util.Arrays;

public class ThreeDWithNew {
    public static void main(String[] args) {
        int[][][] a = new int[2][3][4];
        System.out.println(Arrays.deepToString(a));
    }
}
