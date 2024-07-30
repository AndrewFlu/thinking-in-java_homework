package chapters.eight.ten;

public class Base {
    protected void first() {
        System.out.println("first method");
        second();
        System.out.println("second has been evaluated in first method");
    }

    protected void second() {
        System.out.println("second method");
    }
}
