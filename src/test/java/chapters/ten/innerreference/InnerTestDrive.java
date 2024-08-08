package chapters.ten.innerreference;

public class InnerTestDrive {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().getInner();
        System.out.println(inner.getClass().getSimpleName());
    }
}
