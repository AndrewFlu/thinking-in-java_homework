package chapters.sixteen.arrays.multydimensionalarrays;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;

public class ObjectArrayInitialization {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = new BerylliumSphere[2][5];

        System.out.println(Arrays.deepToString(spheres));
    }
}
