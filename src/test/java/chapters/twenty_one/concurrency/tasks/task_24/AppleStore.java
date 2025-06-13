package chapters.twenty_one.concurrency.tasks.task_24;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppleStore {
    ExecutorService executor = Executors.newCachedThreadPool();
    Queue<IPhone> storage = new LinkedList<>();

    final AppleManufacture appleManufacture = new AppleManufacture(this);
    final AppleClient appleClient = new AppleClient(this);

    public AppleStore() {
        executor.execute(appleManufacture);
        executor.execute(appleClient);
    }

    public static void main(String[] args) {
        new AppleStore();
    }
}
