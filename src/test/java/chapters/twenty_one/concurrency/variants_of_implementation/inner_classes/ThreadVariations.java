package chapters.twenty_one.concurrency.variants_of_implementation.inner_classes;

public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
    }
}
