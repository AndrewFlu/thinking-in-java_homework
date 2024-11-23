package chapters.fifteen.generics.recurring;

public class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void printClassInfo() {
        System.out.println(element.getClass().getSimpleName());
    }
}
