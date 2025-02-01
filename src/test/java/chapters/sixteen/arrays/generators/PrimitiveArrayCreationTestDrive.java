package chapters.sixteen.arrays.generators;

import net.mindview.utils.Generator;

import java.util.Arrays;

public class PrimitiveArrayCreationTestDrive {
    private static final int size = 3;
    public static void main(String[] args) {

        // boolean
        boolean[] bArray = generateBooleanArray(size);
        System.out.println("boolean: " + Arrays.toString(bArray));

        // byte
        byte[] byteArray = generateByteArray(size);
        System.out.println("byte: " + Arrays.toString(byteArray));

        // char
        char[] cArray = generateCharArray(size);
        System.out.println("char: " + Arrays.toString(cArray));

        // short
        short[] shortArray = generateShortArray(size);
        System.out.println("short: " + Arrays.toString(shortArray));

        // int
        int[] intArray = generateIntArray(size);
        System.out.println("int: " + Arrays.toString(intArray));

        // long
        long[] longArray = generateLongArray(size);
        System.out.println("long: " + Arrays.toString(longArray));

        // float
        float[] floatArray = generateFloatArray(size);
        System.out.println("float: " + Arrays.toString(floatArray));

        // double
        double[] doubleArray = generateDoubleArray(size);
        System.out.println("double: " + Arrays.toString(doubleArray));
    }

    private static double[] generateDoubleArray(int size) {
        Generator<Double> generator = new CountingGenerator.Double();
        double[] result = new double[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }

    private static float[] generateFloatArray(int size) {
        Generator<Float> generator = new CountingGenerator.Float();
        float[] result = new float[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }

    private static long[] generateLongArray(int size) {
        Generator<Long> generator = new CountingGenerator.Long();
        long[] result = new long[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }

    private static int[] generateIntArray(int size) {
        Generator<Integer> generator = new CountingGenerator.Integer();
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }

    private static short[] generateShortArray(int size) {
        Generator<Short> generator = new CountingGenerator.Short();
        short[] result = new short[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }

    private static byte[] generateByteArray(int size) {
        Generator<Byte> geneartor = new CountingGenerator.Byte();
        byte[] result = new byte[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = geneartor.next();
        }

        return result;
    }

    private static char[] generateCharArray(int size) {
        Generator<Character> generator = new CountingGenerator.Character();
        char[] result = new char[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }

    private static boolean[] generateBooleanArray(int size) {
        Generator<Boolean> generator = new CountingGenerator.Boolean();
        boolean[] result  = new boolean[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.next();
        }

        return result;
    }
}
