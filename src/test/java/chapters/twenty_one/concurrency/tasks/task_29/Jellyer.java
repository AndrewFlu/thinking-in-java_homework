package chapters.twenty_one.concurrency.tasks.task_29;

// Нанесение желе на тост с маслом
class Jellyer implements Runnable {

    private ToastQueue dryQueue, jelliedQueue;

    public Jellyer(ToastQueue dry, ToastQueue jellied) {
        dryQueue = dry;
        jelliedQueue = jellied;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирует до готовности следующего тоста
                Toast toast = dryQueue.take();
                toast.jelly();
                System.out.println(toast);
                jelliedQueue.put(toast);

            }
        } catch (InterruptedException e) {
            System.out.println("Jellied interrupted");
        }

        System.out.println("Jellied off");
    }
}
