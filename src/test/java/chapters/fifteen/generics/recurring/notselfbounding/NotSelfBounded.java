package chapters.fifteen.generics.recurring.notselfbounding;

public class NotSelfBounded<T> {
    T element;

    NotSelfBounded<T> set(T item) {
        element = item;

        return this;
    }

    T get() {
        return element;
    }
}
