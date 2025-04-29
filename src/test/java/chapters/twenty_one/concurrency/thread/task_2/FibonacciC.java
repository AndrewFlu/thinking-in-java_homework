package chapters.twenty_one.concurrency.thread.task_2;

import static net.mindview.utils.Print.print;

public class FibonacciC implements Runnable {
    private int n = 0;

    public FibonacciC(int n) {
        this.n = n;
    }

    private int fib(int x) {
        if (x < 2)
            return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            print("C " + fib(i) + " ");
        }
    }
}
