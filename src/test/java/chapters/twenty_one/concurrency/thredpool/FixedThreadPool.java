package chapters.twenty_one.concurrency.thredpool;

import chapters.twenty_one.concurrency.runnable.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        int threadCount = 5;
        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
