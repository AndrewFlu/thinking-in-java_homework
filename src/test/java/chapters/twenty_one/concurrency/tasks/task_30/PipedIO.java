package chapters.twenty_one.concurrency.tasks.task_30;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedIO {
    public static void main(String[] args) throws InterruptedException, IOException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(sender);
        executor.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        executor.shutdownNow();
    }
}
