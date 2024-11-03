package chapters.fifteen.generics.instantiate.withconstraint;

public class Foo2<T> {
    private T x;
    public <F extends IFactory<T>> Foo2(F factory, String label) {
        x = factory.create(label);
    }

    public T get() {
        return x;
    }
}
