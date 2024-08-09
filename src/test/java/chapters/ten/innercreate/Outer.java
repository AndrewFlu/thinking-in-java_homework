package chapters.ten.innercreate;

public class Outer {

    public class Inner {

    }

    public static void main(String[] args) {
        Outer  outer = new Outer();
        Inner inner = outer.new Inner();
    }
}
