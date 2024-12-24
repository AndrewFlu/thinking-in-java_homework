package chapters.sixteen.arrays.generators.converttoprimitives;

import chapters.sixteen.arrays.generators.CountingGenerator;
import chapters.sixteen.arrays.generators.Generated;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 7);
        int[] b = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        boolean[] c = ConvertTo.primitive(
                Generated.array(Boolean.class, new CountingGenerator.Boolean(), 5)
        );
        System.out.println(Arrays.toString(c));
    }

}
