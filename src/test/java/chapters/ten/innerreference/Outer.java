package chapters.ten.innerreference;

public class Outer {
    private String info;

    public Outer(String info) {
        this.info = info;
    }

    public Inner getInner() {
        return new Inner();
    }
    class Inner {
        public Inner() {
            System.out.println("Inner class has been created");
        }

        public String toString() {
            return info;
        }
    }
}
