package chapters.twenty_one.concurrency.tasks.task_32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {

    private static Count totalCounter = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int localCounter = 0;
    // Для чтения синхронизация не нужна
    private final int id;

    private final CountDownLatch doneSignal;
    private final CountDownLatch stopSignal;

//    private static volatile boolean canceled = false;

    // Атомарная операция с volatile-полем:
//    public static void cancel() {
//        canceled = true;
//    }

    public Entrance(int id, CountDownLatch doneSignal, CountDownLatch stopSignal) {
        this.id = id;
        this.doneSignal = doneSignal;
        this.stopSignal = stopSignal;
        // Задача остаётся в списке. Также предотвращает уничтожение "мёртвых" задач при уборке мусора:
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!(stopSignal.getCount() == 0)) {
            synchronized (this) {
                ++localCounter;
            }
            System.out.println(this + " Общее число посетителей парка: " + totalCounter.increment());

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
                break;
            }
        }
        System.out.println("Останавливаем подсчёт... " + this);
        doneSignal.countDown();
    }

    public synchronized int getLocalCount() {
        return localCounter;
    }

    public String toString() {
        return "Ворота №" + id + " пропустили посетителей: " + getLocalCount() + ".";
    }

    public static int getTotalCount() {
        return totalCounter.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getLocalCount();
        }
        return sum;
    }
}
