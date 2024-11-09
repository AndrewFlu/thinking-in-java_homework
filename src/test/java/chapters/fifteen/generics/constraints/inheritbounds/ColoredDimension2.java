package chapters.fifteen.generics.constraints.inheritbounds;

import chapters.fifteen.generics.constraints.basicbounds.Dimension;
import chapters.fifteen.generics.constraints.basicbounds.HasColor;

public class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {

    public ColoredDimension2(T item) {
        super(item);
    }

    int getX() {
        return getItem().x;
    }

    int getY() {
        return getItem().y;
    }

    int getZ() {
        return getItem().z;
    }
}
