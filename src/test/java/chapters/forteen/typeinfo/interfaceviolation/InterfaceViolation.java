package chapters.forteen.typeinfo.interfaceviolation;

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.a();
//        a.b(); compile error
        System.out.println(a.getClass().getName()); // B
        if (a instanceof B) {
            B b = (B)a;
            b.b();
        }

    }
}
