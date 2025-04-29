package chapters.twenty_one.concurrency.tasks.task_3;

import chapters.twenty_one.concurrency.runnable.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
