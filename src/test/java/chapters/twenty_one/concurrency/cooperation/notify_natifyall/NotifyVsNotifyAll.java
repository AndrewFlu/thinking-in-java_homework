package chapters.twenty_one.concurrency.cooperation.notify_natifyall;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.execute(new Task());
        }
        executor.execute(new Task2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            boolean prod = true;

            @Override
            public void run() {
                if (prod) {
                    System.out.print("\nTimer task: notify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.print("\nTimer task: notifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);

        TimeUnit.SECONDS.sleep(3); // поработать некоторое время
        timer.cancel();
        System.out.println("\nTimer canceled()");

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll()");
        Task2.blocker.prodAll();

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nShutting down");
        executor.shutdownNow(); // Прервать все задачи
    }
}
