package chapters.twenty_one.concurrency.countdownlatch;

import chapters.seventeen.hashcodes.CountedString;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        // Все должны совместно использовать объект CountDownLatch
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            executor.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            executor.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        executor.shutdown(); // Выход при завершении всех задач
    }
}
