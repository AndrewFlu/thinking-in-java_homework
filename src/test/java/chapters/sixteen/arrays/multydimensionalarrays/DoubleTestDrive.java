package chapters.sixteen.arrays.multydimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class DoubleTestDrive {
    public static void main(String[] args) {
        double[][] d = getDoubleArray(1, 2, 1, 5);
        printArray(d);
    }


    private static double[][] getDoubleArray(int firstDimSize, int secondDimSize, int minValueBound, int maxValueBound) {
        if (minValueBound > maxValueBound)
            throw new IllegalArgumentException("Значение минимального индекса инициализации должно быть меньше максимального");

        Random random = new Random();
        double[][] result = new double[firstDimSize][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new double[secondDimSize];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = random.nextDouble(minValueBound, maxValueBound);
            }
        }

        return result;
    }

    private static void printArray(double[][] d) {
        System.out.println(Arrays.deepToString(d));
    }
}
