package chapters.sixteen.arrays.comparing;

public class CustomObject implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        if (o.getClass().isInstance(this)) {
            CustomObject compareObj = (CustomObject) o;
            return value < compareObj.value ? -1 : (value == compareObj.value ? 0 : 1);
        } else throw new IllegalArgumentException("Передан неверный тип объекта");
    }
}
