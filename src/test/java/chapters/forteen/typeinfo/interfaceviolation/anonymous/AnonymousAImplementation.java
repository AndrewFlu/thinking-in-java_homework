package chapters.forteen.typeinfo.interfaceviolation.anonymous;

import chapters.forteen.typeinfo.interfaceviolation.A;
import chapters.forteen.typeinfo.interfaceviolation.outofpackageaccess.HiddenImplementation;

public class AnonymousAImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.a();
        System.out.println(a.getClass().getName());
        HiddenImplementation.callHiddenMethod(a, "c");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
