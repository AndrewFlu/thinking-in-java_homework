package chapters.fifteen.generics.erasedtype.inheritance;

public class GenericBase<T> {
    private T element;

    public T get() {
        return element;
    }

    public void set(T element) {
        this.element = element;
    }
}
