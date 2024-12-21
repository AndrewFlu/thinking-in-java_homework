package chapters.sixteen.arrays.multydimensionalarrays;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Arrays;

public class BerylliumTestDrive {
    public static void main(String[] args) {
        BerylliumSphere[][] doubleArraySpheres = getDoubleBerylliumSpheresArray(3, 4);
        System.out.println(Arrays.deepToString(doubleArraySpheres));

        BerylliumSphere[][][] tripleBerylliumSpheresArray = getTripleBerylliumSpheresArray(2, 5, 1);
        System.out.println(Arrays.deepToString(tripleBerylliumSpheresArray));
    }

    private static BerylliumSphere[][] getDoubleBerylliumSpheresArray(int firstArrLength, int secArrLength) {
        BerylliumSphere[][] result = new BerylliumSphere[firstArrLength][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BerylliumSphere[secArrLength];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new BerylliumSphere();
            }
        }

        return result;
    }

    private static BerylliumSphere[][][] getTripleBerylliumSpheresArray(int firstArrLength, int secArrLength, int thirdArrLength) {
        BerylliumSphere[][][] result = new BerylliumSphere[firstArrLength][][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BerylliumSphere[secArrLength][];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new BerylliumSphere[thirdArrLength];
                for (int k = 0; k < result[i][j].length; k++) {
                    result[i][j][k] = new BerylliumSphere();
                }
            }
        }

        return result;
    }
}
