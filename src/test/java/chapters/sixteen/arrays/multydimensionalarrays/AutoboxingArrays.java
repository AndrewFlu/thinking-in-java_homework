package chapters.sixteen.arrays.multydimensionalarrays;

import java.util.Arrays;

public class AutoboxingArrays {
    public static void main(String[] args) {
        Integer[][] a = {
                {1, 2, 3, 4, 5},
                {51, 52, 53, 54, 55},
                {100, 101},
        };
        System.out.println(Arrays.deepToString(a));
    }
}
