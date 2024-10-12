package chapters.forteen.typeinfo.interfaceviolation.anonymous;

import chapters.forteen.typeinfo.interfaceviolation.A;

import static net.midview.Print.print;

public class AnonymousA {
    public static A makeA() {
        return new A() {

            @Override
            public void a() {
                print("public anonymous C.a()");
            }

            public void c() {
                print("public anonymous C.c()");
            }

            void u() {
                print("package-private anonymous C.u()");
            }

            protected void v() {
                print("protected anonymous C.v()");
            }

            private void w() {
                print("private anonymous C.w()");
            }
        };
    }
}
