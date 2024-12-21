package chapters.sixteen.arrays.multydimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class TripleTestDrive {
    public static void main(String[] args) {
        double[][][] d = getTripleArray(2, 3, 1, 1, 5);
        printTripleArray(d);
    }

    private static void printTripleArray(double[][][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    private static double[][][] getTripleArray(int firstArrayLength, int secArrLength, int thirdArrLength, int minBound, int maxBound) {
        var random = new Random();
        double[][][] result = new double[firstArrayLength][][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new double[secArrLength][];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new double[thirdArrLength];
                for (int k = 0; k < result[i][j].length; k++) {
                    result[i][j][k] = random.nextDouble(minBound, maxBound);
                }
            }
        }

        return result;
    }
}
