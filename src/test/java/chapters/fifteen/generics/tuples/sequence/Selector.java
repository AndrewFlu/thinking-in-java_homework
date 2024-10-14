package chapters.fifteen.generics.tuples.sequence;

public interface Selector<T> {
    boolean end();
    T current();
    void next();
}
