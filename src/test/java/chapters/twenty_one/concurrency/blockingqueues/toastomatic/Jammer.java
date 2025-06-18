package chapters.twenty_one.concurrency.blockingqueues.toastomatic;

// Нанесение джема на тост с маслом
class Jammer implements Runnable {

    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue buttered, ToastQueue finished) {
        butteredQueue = buttered;
        finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирует до готовности следующего тоста
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);

            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }

        System.out.println("Jammer off");
    }
}
