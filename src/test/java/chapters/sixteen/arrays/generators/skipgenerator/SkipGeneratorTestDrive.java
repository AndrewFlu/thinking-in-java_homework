package chapters.sixteen.arrays.generators.skipgenerator;

import chapters.sixteen.arrays.generators.Generated;
import chapters.sixteen.arrays.generators.converttoprimitives.ConvertTo;

import java.util.Arrays;

import static net.mindview.utils.Print.print;

public class SkipGeneratorTestDrive {
    public static void main(String[] args) {
        int size = 5;

        boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class, new SkipGenerator.Boolean(true), size));
        print("boolean[] a1 = " + Arrays.toString(a1));

        byte[] a2 = ConvertTo.primitive(Generated.array(Byte.class, new SkipGenerator.Byte((byte) 3), size));
        print("byte[] a2 = " + Arrays.toString(a2));

        char[] a3 = ConvertTo.primitive(Generated.array(Character.class, new SkipGenerator.Character(2), size));
        print("char[] a3 = " + Arrays.toString(a3));

        short[] a4 = ConvertTo.primitive(Generated.array(Short.class, new SkipGenerator.Short((short) 2), size));
        print("short[] a4 = " + Arrays.toString(a4));

        int[] a5 = ConvertTo.primitive(Generated.array(Integer.class, new SkipGenerator.Integer(2), size));
        print("int[] a5 = " + Arrays.toString(a5));

        long[] a6 = ConvertTo.primitive(Generated.array(Long.class, new SkipGenerator.Long(3), size));
        print("long[] a6 = " + Arrays.toString(a6));

        float[] a7 = ConvertTo.primitive(Generated.array(Float.class, new SkipGenerator.Float(3), size));
        print("float[] a7 = " + Arrays.toString(a7));

        double[] a8 = ConvertTo.primitive(Generated.array(Double.class, new SkipGenerator.Double(3), size));
        print("double[] a8 = " + Arrays.toString(a8));


    }
}
