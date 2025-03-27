package chapters.forteen.typeinfo.interfaceviolation.innerimplementation;

import chapters.forteen.typeinfo.interfaceviolation.A;

import static net.mindview.utils.Print.print;

public class InnerA {
    private static class C implements A {

        @Override
        public void a() {
            print("public inner C.a()");
        }

        public void c() {
            print("public inner C.c()");
        }

        void u() {
            print("package-private inner C.u()");
        }

        protected void v() {
            print("protected inner C.v()");
        }

        private void w() {
            print("private inner C.w()");
        }
    }

    public static A makeA() {
        return new C();
    }
}
