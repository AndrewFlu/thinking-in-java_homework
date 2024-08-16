package chapters.ten.multiimplementation.abu;

public class UArrayTestDrive {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        B b = new B();

        b.addU(a1.getU());
        b.addU(a2.getU());
        b.addU(a3.getU());

        b.executeUArray();
        System.out.println("");
        b.resetArgumentInUArray(0);
        b.executeUArray();
    }
}
