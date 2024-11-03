package chapters.fifteen.generics.instantiate.withconstraint;

public class FactoryConstraint {
    public static void main(String[] args) {
        Foo2<Integer> integerFoo2 = new Foo2<>(new IntegerFactory(), "0");
        System.out.println(integerFoo2.get());

        Foo2<Widget> intoFactoryConstraint = new Foo2<>(new Widget.Factory(), "Into FactoryConstraint");
        System.out.println(intoFactoryConstraint.get());

    }
}
