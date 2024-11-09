package chapters.fifteen.generics.constraints.inheritbounds;

import chapters.fifteen.generics.constraints.basicbounds.HasColor;

import java.awt.*;

public class Colored2<T extends HasColor> extends HoldItem<T> {
    public Colored2(T item) {
        super(item);
    }

    public Color color() {
        return getItem().getColor();
    }
}
