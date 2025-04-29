package chapters.twenty_one.concurrency.tasks.task_2;

public class FibonacciTestDrive {
    public static void main(String[] args) {
        Thread f1 = new Thread(new FibonacciA(10));
        Thread f2 = new Thread(new FibonacciB(10));
        Thread f3 = new Thread(new FibonacciC(10));
        f1.start();
        f2.start();
        f3.start();
    }
}
