package chapters.sixteen.arrays.returningarray;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;
import java.util.Random;

public class BerylliumSphereArray {
    private static final Random random = new Random();

    public static BerylliumSphere[] getBerylliumSphereArray(int desiredLength) {
        if (desiredLength < 0 ) throw new IllegalArgumentException("Desired length must be a positive number");
        BerylliumSphere[] array = new BerylliumSphere[desiredLength];
        for (int i = 0; i < desiredLength; i++) {
            array[i] = new BerylliumSphere();
        }

        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(getBerylliumSphereArray(7)));
        }
    }
}
