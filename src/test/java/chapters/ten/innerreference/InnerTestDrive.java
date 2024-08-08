package chapters.ten.innerreference;

public class InnerTestDrive {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer("Outer class").getInner();
        Outer.Inner inner2 = new Outer("Outer class 2").getInner();

        System.out.println(inner.toString());
        System.out.println(inner2);
    }
}
