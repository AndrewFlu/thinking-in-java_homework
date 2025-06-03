package chapters.twenty_one.concurrency.closing_tasks.ornamental_garden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {

    private static Count totalCounter = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int localCounter = 0;
    // Для чтения синхронизация не нужна
    private final int id;
    private static volatile boolean canceled = false;

    // Атомарная операция с volatile-полем:
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        // Задача остаётся в списке. Также предотвращает уничтожение "мёртвых" задач при уборке мусора:
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++localCounter;
            }
            System.out.println(this + " Общее число посетителей парка: " + totalCounter.increment());

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }
        System.out.println("Останавливаем подсчёт... " + this);
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
