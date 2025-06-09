package chapters.twenty_one.concurrency.tasks.task_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CleaningMachine {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Washer washer = new Washer();
        executor.execute(washer);
        executor.execute(new Dryer(washer));
        executor.shutdown();
    }
}
