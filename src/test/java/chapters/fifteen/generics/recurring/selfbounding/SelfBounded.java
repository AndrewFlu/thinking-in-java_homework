package chapters.fifteen.generics.recurring.selfbounding;

public class SelfBounded<T extends SelfBounded<T>> {
    T element;

    public SelfBounded<T> set (T arg) {
        element = arg;

        return this;
    }

    T get() {
        return element;
    }
}
