package chapters.twenty_one.concurrency.tasks.task_9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities_9 implements Runnable {

    private int countdown = 5;
    private volatile double d; // без отпимизации

    public String toString() {
        return Thread.currentThread() + ": " + countdown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100_000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }

            System.out.println(this);
            if (--countdown == 0)
                return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory());
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities_9());
        }
        exec.shutdown();
    }
}
