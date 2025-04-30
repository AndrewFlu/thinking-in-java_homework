package chapters.twenty_one.concurrency.tasks.task_5;

import net.mindview.utils.Generator;

import java.util.concurrent.Callable;

public class FibonacciSum implements Callable<Integer>, Generator<Integer> {

    private int counter;
    private final int number;

    public FibonacciSum(int number) {
        this.number = number;
    }

    private int fib(int n) {
        if (n < 2)
            return 1;

        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum += next();
        }

        return sum;
    }

    @Override
    public Integer next() {
        return fib(counter++);
    }
}
