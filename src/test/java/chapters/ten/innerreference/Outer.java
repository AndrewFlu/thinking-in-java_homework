package chapters.ten.innerreference;

public class Outer {
    public Inner getInner() {
        return new Inner();
    }
    class Inner {
        public Inner() {
            System.out.println("Inner class has been created");
        }
    }
}
