package chapters.sixteen.arrays.multydimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class RaggedArray {
    public static void main(String[] args) {
        Random random = new Random(47);
        // трёхмерный массив с векторами переменной длины
        int[][][] a = new int[random.nextInt(3)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[random.nextInt(4)][];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[random.nextInt(5)];
            }
        }

        System.out.println(Arrays.deepToString(a));
    }
}
