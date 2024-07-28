package chapters.seven.inheritance.reusing;

import static net.midview.Print.print;

public class OverridingPrivate2 extends OverridingPrivate{

    public final void f() {
        print("OverridingPrivate2.f()");
    }

    public void g() {
        print("OverridingPrivate2.g()");
    }
}
