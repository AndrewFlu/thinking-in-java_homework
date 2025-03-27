package chapters.sixteen.arrays.comparing.pattern_strategy;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;
import chapters.sixteen.arrays.generators.BerylliumSphereGenerator;
import chapters.sixteen.arrays.generators.Generated;

import java.util.Arrays;

import static net.mindview.utils.Print.print;

public class BerylliumSphereSorting {
    public static void main(String[] args) {
        BerylliumSphere[] b = Generated.array(new BerylliumSphere[5], new BerylliumSphereGenerator());
        print("before sorting:");
        print(Arrays.toString(b));
        print("after sorting:");
        print(Arrays.toString(b));
        print("after sorting (reverse):");
        Arrays.sort(b, new BerylliumSphereComparator());
        print(Arrays.toString(b));
    }
}
