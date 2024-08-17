package chapters.ten.closures;

public class MyIncrement {
    private int i = 0;

    public void increment() {
        i++;
        System.out.println("MyIncrement.increment() i = " + i);
    }

    public static void staticIncrement(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}
