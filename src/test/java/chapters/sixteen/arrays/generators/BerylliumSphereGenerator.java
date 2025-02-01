package chapters.sixteen.arrays.generators;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;
import net.mindview.utils.Generator;

public class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}
