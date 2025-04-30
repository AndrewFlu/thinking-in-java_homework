package chapters.twenty_one.concurrency.tasks.task_10;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AwaitingInfo implements Runnable {
    private static int counter = 0;

    private final int id = counter++;
    private final long waitingDuration;


    public AwaitingInfo() {
        waitingDuration = new Random().nextInt(1, 11);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(waitingDuration);
        } catch (InterruptedException e) {
            System.err.println("Interrupted!");
        }

        System.out.printf("Ожидание задачи #%d составило %d сек.%n", id, waitingDuration);
    }
}
