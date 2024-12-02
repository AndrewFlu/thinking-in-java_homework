package chapters.fifteen.generics.mixins;

import java.awt.*;

public class ColoredImpl implements Colored {
    private Color color;
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
