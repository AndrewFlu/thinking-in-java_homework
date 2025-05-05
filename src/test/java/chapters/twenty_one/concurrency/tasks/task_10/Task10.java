package chapters.twenty_one.concurrency.tasks.task_10;

import java.util.concurrent.ExecutionException;

public class Task10 {
    public static void main(String[] args) {
        SummFibonacciTask10 fib = new SummFibonacciTask10();
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println("Sum of first " + i + " Fibonacci numbers = " );
                System.out.println(fib.runTask(i).get());
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        } catch (ExecutionException e) {
            System.err.println(e);
        } finally {
            fib.exec.shutdown();
        }
    }
}
