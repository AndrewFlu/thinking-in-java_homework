package chapters.sixteen.arrays.copying;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;
import chapters.sixteen.arrays.generators.BerylliumSphereGenerator;
import chapters.sixteen.arrays.generators.Generated;

import java.util.Arrays;

import static net.mindview.utils.Print.print;

public class BerylliumSphereCopy {
    public static void main(String[] args) {
        BerylliumSphere[] srcArray = new BerylliumSphere[5];
        Generated.array(srcArray, new BerylliumSphereGenerator());
        print("srcArray = " + Arrays.toString(srcArray));

        BerylliumSphere[] targetArray = new BerylliumSphere[10];
        System.arraycopy(srcArray, 0, targetArray, 0, srcArray.length);
        print("targetArray = " + Arrays.toString(targetArray));
        print("srcArray = " + Arrays.toString(srcArray));
        print("is first element the same? " + srcArray[0].equals(targetArray[0]));
    }
}
