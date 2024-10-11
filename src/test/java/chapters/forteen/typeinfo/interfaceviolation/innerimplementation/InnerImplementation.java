package chapters.forteen.typeinfo.interfaceviolation.innerimplementation;

import chapters.forteen.typeinfo.interfaceviolation.A;
import chapters.forteen.typeinfo.interfaceviolation.outofpackageaccess.HiddenImplementation;

public class InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.a();

        System.out.println(a.getClass().getName());
        // Reflection still get into the private class
        HiddenImplementation.callHiddenMethod(a, "c");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
