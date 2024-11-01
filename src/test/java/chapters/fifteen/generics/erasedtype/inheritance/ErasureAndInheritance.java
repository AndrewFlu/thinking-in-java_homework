package chapters.fifteen.generics.erasedtype.inheritance;

import chapters.fifteen.generics.erasedtype.MacBook;
import chapters.forteen.typeinfo.instanceofvsclass.Derived;

public class ErasureAndInheritance {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object object = derived2.get();
        derived2.set(object);

        Derived1<MacBook> derived1 = new Derived1<>();
        Object object1 = derived2.get();
        derived2.set(object1);
    }
}
