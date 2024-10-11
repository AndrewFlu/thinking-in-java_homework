package chapters.forteen.typeinfo.interfaceviolation.packageaccess;

import chapters.forteen.typeinfo.interfaceviolation.A;

import static net.midview.Print.print;

class C implements A {
    @Override
    public void a() {
        print("public C.a()");
    }

    public void c() {
        print("public C.c()");
    }

    void d() {
        print("package-private C.d()");
    }

    protected void v() {
        print("protected C.v()");
    }

    private void w() {
        print("private C.w()");
    }
}
