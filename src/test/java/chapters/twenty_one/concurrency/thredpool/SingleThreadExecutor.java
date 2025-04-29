package chapters.twenty_one.concurrency.thredpool;

import chapters.twenty_one.concurrency.runnable.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
