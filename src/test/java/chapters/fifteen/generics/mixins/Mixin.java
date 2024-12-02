package chapters.fifteen.generics.mixins;

import java.awt.*;

public class Mixin extends BasicImpl implements TimeStamped, SerialNumbered, Colored {
    private final TimeStamped timeStamped = new TimeStampedImpl();
    private final SerialNumbered serialNumbered = new SerialNumberedImpl();
    private final Colored colored = new ColoredImpl();


    @Override
    public long getSerialNumbered() {
        return serialNumbered.getSerialNumbered();
    }

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public void setColor(Color color) {
        colored.setColor(color);
    }

    @Override
    public Color getColor() {
        return colored.getColor();
    }
}
