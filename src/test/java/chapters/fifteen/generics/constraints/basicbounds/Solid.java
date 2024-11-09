package chapters.fifteen.generics.constraints.basicbounds;

import java.awt.*;

public class Solid<T extends Dimension & HasColor & Weight> {
    private final T item;

    public Solid(T item) {
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

    public int weight() {
        return item.weight();
    }
}
