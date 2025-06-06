package chapters.twenty_one.concurrency.tasks.task_18;

import java.util.concurrent.TimeUnit;

public class NoRunnable {
    public void sleep() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("NoRunnable.sleep() interrupted");
        }
        System.out.println("Метод NoRunnable.sleep() завершился");
    }
}
