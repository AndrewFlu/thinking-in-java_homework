package chapters.seven.inheritance.abc;

public class C extends A {
    B fieldB;

    public C(int a, B fieldB) {
        super(a);
        System.out.println("конструктор: C()");
        this.fieldB = fieldB;
    }

    public static void main(String[] args) {
        C c = new C(5, new B(1));
    }
}
