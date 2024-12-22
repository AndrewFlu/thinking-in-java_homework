package chapters.sixteen.arrays.containercomparison;

import chapters.sixteen.arrays.generators.BerylliumSphereGenerator;
import chapters.sixteen.arrays.generators.CountingGenerator;
import chapters.sixteen.arrays.generators.Generated;

import java.util.Arrays;
import java.util.List;

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator(), 10);
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = List.of(Generated.array(Integer.class, new CountingGenerator.Integer(), 5));
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
