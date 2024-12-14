package chapters.sixteen.arrays.options;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;

public class ArrayAsArgumentIntoMethod {
    private static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        BerylliumSphere[] a = new BerylliumSphere[1];
        BerylliumSphere[] b = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};

        printArray(a);
        printArray(b);
        printArray(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
//        printArray({new BerylliumSphere(), new BerylliumSphere()}); // array initializer s not allowed here

        BerylliumSphere[] c = {new BerylliumSphere(), new BerylliumSphere()};
        printArray(c);
    }
}
