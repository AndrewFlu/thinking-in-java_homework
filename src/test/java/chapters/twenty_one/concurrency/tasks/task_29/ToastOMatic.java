package chapters.twenty_one.concurrency.tasks.task_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                jelliedQueue = new ToastQueue(),
                peanutButteredQueue = new ToastQueue();
        SandwichQueue sandwichQueue = new SandwichQueue();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Toaster(dryQueue));
        executor.execute(new Jellyer(dryQueue, jelliedQueue));
        executor.execute(new PeanutButterer( dryQueue, peanutButteredQueue));
        executor.execute(new SandwichMaker(peanutButteredQueue, jelliedQueue, sandwichQueue));
        executor.execute(new SandwichEater(sandwichQueue));
        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }
}
