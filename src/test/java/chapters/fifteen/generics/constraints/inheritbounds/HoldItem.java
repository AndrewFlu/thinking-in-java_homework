package chapters.fifteen.generics.constraints.inheritbounds;

public class HoldItem<T> {
    private final T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
