package chapters.sixteen.arrays.generators;

import utils.Generator;

import java.util.Arrays;

public class CountingGeneratorTestDrive {
    public static void main(String[] args) {
        double[] d = getArray(new CountingGenerator.Double(), 5);
        System.out.println(Arrays.toString(d));
    }

    private static double[] getArray(Generator<Double> generator, int size) {
        double[] result = new double[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }
}
