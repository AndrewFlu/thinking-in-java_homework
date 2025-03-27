package chapters.five;

import static net.mindview.utils.Print.print;

public class ExplicitStatic {
    public static void main(String[] args) {
        print("Inside main()");
        Cups.cup1.method(77); // 1
    }

    static  Cups caps1 = new Cups(); // 2
    static  Cups caps2 = new Cups(); // 3
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        print("Constructor of Cups()");
    }
}

class Cup {
    public Cup(int number) {
        print("This is a cup " + number);
    }

    public void method(int number) {
        print("this is a method with parameter number = " + number);
    }
}
