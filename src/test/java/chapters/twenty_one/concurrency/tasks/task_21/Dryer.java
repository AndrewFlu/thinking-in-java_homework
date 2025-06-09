package chapters.twenty_one.concurrency.tasks.task_21;

import java.util.concurrent.TimeUnit;

public class Dryer implements Runnable {

    private Washer washer;

    public Dryer(Washer washer) {
        this.washer = washer;
    }

    @Override
    public void run() {
        try {
            System.out.println("Drier is running");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Dryer interrupted while washing");
        }
        synchronized (washer) {
            System.out.println("Dryer passing job to washer");
            washer.notifyAll();
        }
    }
}
