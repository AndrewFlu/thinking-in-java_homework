package chapters.twenty_one.concurrency.tasks.task_29;


// Нанесение масла
public class PeanutButterer implements Runnable {

    private ToastQueue dryQueue, peanutButteredQueue;

    public PeanutButterer(ToastQueue dry, ToastQueue peanutButtered) {
        dryQueue = dry;
        peanutButteredQueue = peanutButtered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирует до готовности следующего тоста
                Toast toast = dryQueue.take();
                toast.peanutButter();
                System.out.println(toast);
                peanutButteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("PeanutButterer interrupted");
        }

        System.out.println("PeanutButterer off");
    }
}
