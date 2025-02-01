package chapters.sixteen.arrays.generators;

import net.mindview.utils.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

public class CountingGeneratorTestDrive {
    public static void main(String[] args) {
        double[] d = getArray(new CountingGenerator.Double(), 5);
        System.out.println(Arrays.toString(d));

        String generatedStr = fillString(new CountingGenerator.Character(), 10);
        System.out.println(generatedStr);

        BigDecimal[] b = Generated.array(BigDecimal.class, new CountingGenerator.BigDecimal(), 5);
        System.out.println(Arrays.toString(b));
    }

    private static String fillString(Generator<Character> generator, int size) {
        char[] result = new char[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return String.valueOf(result);
    }

    private static double[] getArray(Generator<Double> generator, int size) {
        double[] result = new double[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }
}
