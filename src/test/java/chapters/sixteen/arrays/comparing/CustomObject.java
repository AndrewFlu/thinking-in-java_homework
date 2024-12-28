package chapters.sixteen.arrays.comparing;

import java.util.Objects;

public class CustomObject {
    private final int value;

    public CustomObject(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        else if (o == null) {
            return false;
        }
        if (o.getClass().isInstance(this)) {
            return ((CustomObject) o).value == value;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "value=" + value +
                '}';
    }
}
