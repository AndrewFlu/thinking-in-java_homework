package chapters.ten.multiimplementation.abc;

public class C extends A {
    B makeB() {
        return new B() {};
    }
}
