package chapters.twenty_one.concurrency.tasks.task_25_26;

public class BusBoy implements Runnable {

    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.cleaned) {
                        wait();
                    }
                }
                if (!restaurant.cleaned) {
                    restaurant.cleaned = true;
                    System.out.println("Уборщик прибрал со стола (cleaned = " + restaurant.cleaned + ")");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}
