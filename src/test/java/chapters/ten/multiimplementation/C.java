package chapters.ten.multiimplementation;

public class C extends A {
    B makeB() {
        return new B() {};
    }
}
