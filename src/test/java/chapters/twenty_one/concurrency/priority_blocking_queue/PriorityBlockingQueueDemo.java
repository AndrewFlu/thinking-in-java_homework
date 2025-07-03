package chapters.twenty_one.concurrency.priority_blocking_queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queu = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queu, exec));
        exec.execute(new PrioritizedTaskConsumer(queu));
    }
}
