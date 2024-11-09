package chapters.fifteen.generics.constraints.basicbounds;

import java.awt.*;

//! public class ColoredDimension<T extends HasColor & Dimension> // class first, then interface
public class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Color color() {
        return item.getColor();
    }

    public int getX() {
        return item.x;
    }

    public int getY() {
        return item.y;
    }

    public int getZ() {
        return item.z;
    }
}
