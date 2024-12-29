package chapters.sixteen.arrays.comparing.pattern_strategy;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.Comparator;

public class BerylliumSphereComparator implements Comparator<BerylliumSphere> {
    @Override
    public int compare(BerylliumSphere o1, BerylliumSphere o2) {
        return o1.compareTo(o2) > 0 ? -1 : (o1.compareTo(o2) == 0 ? 0 : 1);
    }
}
