package chapters.fifteen.generics.constraints.inheritbounds;

import chapters.fifteen.generics.constraints.basicbounds.Dimension;
import chapters.fifteen.generics.constraints.basicbounds.HasColor;
import chapters.fifteen.generics.constraints.basicbounds.Solid;
import chapters.fifteen.generics.constraints.basicbounds.Weight;

public class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{

    public Solid2(T item) {
        super(item);
    }

    int weight() {
        return getItem().weight();
    }
}
