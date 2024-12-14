package chapters.sixteen.arrays.containercomparison;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CounterComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);


        List<BerylliumSphere> berylliumSphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            berylliumSphereList.add(new BerylliumSphere());
        }
        System.out.println(berylliumSphereList);
        System.out.println(berylliumSphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
