package chapters.fifteen.generics.instantiate.withconstraint;

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new Widget.Factory());
    }
}
