package chapters.seven.inheritance.reusing;

import static net.mindview.utils.Print.print;

public class OverridingPrivate extends WithFinals {

    private final void f() {
        print("OverridingPrivate.f()");
    }


    private void g() {
        print("OverridingPrivate.g()");
    }
}
