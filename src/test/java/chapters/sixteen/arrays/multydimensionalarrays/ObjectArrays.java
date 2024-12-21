package chapters.sixteen.arrays.multydimensionalarrays;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;

public class ObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()},
        };

        System.out.println(Arrays.deepToString(spheres));
    }
}
