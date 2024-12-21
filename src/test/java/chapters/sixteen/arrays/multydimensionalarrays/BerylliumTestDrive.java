package chapters.sixteen.arrays.multydimensionalarrays;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;

public class BerylliumTestDrive {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = getBerylliumSpheresArray(3, 4);

        System.out.println(Arrays.deepToString(spheres));
    }

    private static BerylliumSphere[][] getBerylliumSpheresArray(int firstArrLength, int secArrLength) {
        BerylliumSphere[][] result = new BerylliumSphere[firstArrLength][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BerylliumSphere[secArrLength];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new BerylliumSphere();
            }
        }

        return result;
    }
}
