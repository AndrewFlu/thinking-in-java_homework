package chapters.twenty_one.concurrency.tasks.task_32;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        int SIZE = 5;
        CountDownLatch stopSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(SIZE);

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i < SIZE; i++) {
            exec.execute(new Entrance(i, doneSignal, stopSignal));
        }
        // Поработать некоторое время, затем оставновиться и собрать данные:
        TimeUnit.SECONDS.sleep(3);

        // close the entrances
        stopSignal.countDown();

        exec.shutdown();

        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated!");
        }
        System.out.println("Всего парк посетило: " + Entrance.getTotalCount());
        System.out.println("Сумма посетителей, вошедших через все ворота парка: " + Entrance.sumEntrances());
    }
}
