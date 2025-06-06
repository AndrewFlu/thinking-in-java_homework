package chapters.twenty_one.concurrency.tasks.task_19;

import chapters.twenty_one.concurrency.closing_tasks.ornamental_garden.Entrance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden19 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i < 4; i++) {
            exec.execute(new Entrance(i));
        }
        // Поработать некоторое время, затем оставновиться и собрать данные:
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();

        if (! exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated!");
        }
        System.out.println("Всего парк посетило: " + Entrance.getTotalCount());
        System.out.println("Сумма посетителей, вошедших через все ворота парка: " + Entrance.sumEntrances());

    }
}
