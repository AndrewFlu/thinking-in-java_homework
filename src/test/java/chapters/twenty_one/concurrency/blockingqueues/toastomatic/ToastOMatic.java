package chapters.twenty_one.concurrency.blockingqueues.toastomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Toaster(dryQueue));
        executor.execute(new Butterer( dryQueue, butteredQueue));
        executor.execute(new Jammer(butteredQueue, finishedQueue));
        executor.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }
}
