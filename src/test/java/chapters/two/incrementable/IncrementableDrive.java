package chapters.two.incrementable;

public class IncrementableDrive {
    public static void main(String[] args) {
        System.out.println(StaticTest.i);
        Incrementable.increment();
        System.out.println(StaticTest.i);
    }
}
