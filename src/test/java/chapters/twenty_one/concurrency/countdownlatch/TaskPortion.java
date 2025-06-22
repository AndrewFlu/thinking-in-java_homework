package chapters.twenty_one.concurrency.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class TaskPortion implements Runnable {

    private static int counter = 0;
    private static Random random = new Random(47);

    private final int id = counter++;

    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException ignore) {
            // Допустимый способ выхода
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2_000));
        System.out.println(this + " completed");
    }

    public String toString() {
        return String.format("%1$-3d ", id);
    }
}
