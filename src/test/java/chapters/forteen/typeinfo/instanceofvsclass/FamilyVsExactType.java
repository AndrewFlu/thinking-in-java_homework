package chapters.forteen.typeinfo.instanceofvsclass;

import static net.midview.Print.print;

public class FamilyVsExactType {
    static void test(Object x) {
        print(String.format("Тестируем x типа [%s]", x.getClass()));
        print(String.format("x instanceOf Base: [%s]", x instanceof Base));
        print(String.format("x instanceOf Derived: [%s]", x instanceof Derived));
        print(String.format("Base.isInstance(x): [%s]", Base.class.isInstance(x)));
        print(String.format("Derived.isInstance(x): [%s]", Derived.class.isInstance(x)));

        print(String.format("x.getClass == Base.class: [%s]", x.getClass() == Base.class));
        print(String.format("x.getClass == Derived.class: [%s]", x.getClass() == Derived.class));

        print(String.format("x.getClass.equals(Base.class): [%s]", x.getClass().equals(Base.class)));
        print(String.format("x.getClass.equals(Derived.class): [%s]", x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        print("");
        test(new Derived());
    }
}
