package chapters.ten.outeraccess;

public class Outer {
    void outerInfo() {
        System.out.println("Outer.outerInfo()");
    }

    public class Inner {
        public Outer getOuter() {
            return Outer.this;
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.getInner();
        inner.getOuter().outerInfo();
    }
}
