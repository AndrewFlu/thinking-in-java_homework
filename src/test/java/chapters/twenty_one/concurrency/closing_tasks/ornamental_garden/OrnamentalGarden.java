package chapters.twenty_one.concurrency.closing_tasks.ornamental_garden;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i < 4; i++) {
            exec.execute(new Entrance(i));
        }
        // Поработать некоторое время, затем оставновиться и собрать данные:
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();

        if (! exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated!");
        }
        System.out.println("Всего парк посетило: " + Entrance.getTotalCount());
        System.out.println("Сумма посетителей, вошедших через все ворота парка: " + Entrance.sumEntrances());

    }
}
