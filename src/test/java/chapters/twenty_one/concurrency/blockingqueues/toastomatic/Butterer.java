package chapters.twenty_one.concurrency.blockingqueues.toastomatic;


// Нанесение масла
public class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dry, ToastQueue buttered) {
        dryQueue = dry;
        butteredQueue = buttered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирует до готовности следующего тоста
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }

        System.out.println("Butterer off");
    }
}
