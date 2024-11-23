package chapters.fifteen.generics.recurring;

public class BasicHolder<T> {
    T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }

    public void printClassInfo() {
        System.out.println(element.getClass().getSimpleName());
    }
}
