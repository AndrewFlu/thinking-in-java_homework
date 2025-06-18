package chapters.twenty_one.concurrency.blockingqueues.toastomatic;

// Потребление тоста
class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finished) {
        finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирует до готовности следующего тоста
                Toast toast = finishedQueue.take();
                // Проверить, что все тосты следуют по порядку и все намазаны джемом
                if (toast.getId() != counter++ || toast.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>> Error: " + toast);
                    System.exit(1);
                } else {

                }
                    System.out.println("Chomp! " + toast + "\n");
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }

        System.out.println("Eater off");
    }
}
