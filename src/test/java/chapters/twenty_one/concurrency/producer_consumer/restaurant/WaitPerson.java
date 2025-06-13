package chapters.twenty_one.concurrency.producer_consumer.restaurant;

class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait(); // ожидать, пока повар приготовит блюдо
                    }
                }
                System.out.println("Официант получил заказ: " + restaurant.meal);

                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // готов к следующему блюду
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }

    }
}
