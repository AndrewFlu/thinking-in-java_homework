package chapters.twenty_one.concurrency.tasks.task_29;

// Потребление тоста
class SandwichEater implements Runnable {

    private SandwichQueue sandwichQueue;
    private int counter = 0;

    public SandwichEater(SandwichQueue sandwichQueue) {
        this.sandwichQueue = sandwichQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирует до готовности следующего тоста
                Sandwich sandwich = sandwichQueue.take();
                // Проверить, что все тосты следуют по порядку и все намазаны джемом
                if (sandwich.getId() != counter++ ||
                        sandwich.getTop().getStatus() != Toast.Status.JELLIED ||
                        sandwich.getBottom().getStatus() != Toast.Status.PEANUT_BUTTERED) {
                    System.out.println(">>>> Error: " + sandwich);
                    System.exit(1);
                } else {

                }
                System.out.println("Chomp! " + sandwich + "\n");
            }
        } catch (InterruptedException e) {
            System.out.println("SandwichEater interrupted");
        }

        System.out.println("SandwichEater off");
    }
}
