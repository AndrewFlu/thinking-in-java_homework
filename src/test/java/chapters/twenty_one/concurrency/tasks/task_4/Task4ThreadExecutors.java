package chapters.twenty_one.concurrency.tasks.task_4;

import chapters.twenty_one.concurrency.tasks.task_2.FibonacciA;
import chapters.twenty_one.concurrency.tasks.task_2.FibonacciB;
import chapters.twenty_one.concurrency.tasks.task_2.FibonacciC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task4ThreadExecutors {
    public static void main(String[] args) {
        System.out.println("Single Thread Executor in work: ");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new FibonacciA(5));
        singleThreadExecutor.execute(new FibonacciB(4));
        singleThreadExecutor.execute(new FibonacciC(3));
        singleThreadExecutor.shutdown();
        System.out.println("After Single Thread Executor");

        System.out.println("Cached Thread Pool Executor in work: ");
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        cachedExecutor.execute(new FibonacciA(4));
        cachedExecutor.execute(new FibonacciB(5));
        cachedExecutor.execute(new FibonacciC(6));
        cachedExecutor.shutdown();
        System.out.println("After Cached Thread Pool Executor");

        System.out.println("Fixed Thread Pool Executor in work: ");
        ExecutorService fixedExec = Executors.newFixedThreadPool(2);
        fixedExec.execute(new FibonacciA(4));
        fixedExec.execute(new FibonacciB(5));
        fixedExec.shutdown();
        System.out.println("After Fixed Thread Pool Executor");
    }
}
