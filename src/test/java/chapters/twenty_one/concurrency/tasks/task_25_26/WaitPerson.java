package chapters.twenty_one.concurrency.tasks.task_25_26;

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

                // доставить блюдо
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // готов к следующему блюду
                }
                // убрать ос стола
                synchronized (restaurant.busBoy) {
                    restaurant.cleaned = false;
                    restaurant.busBoy.notifyAll();
                }
                System.out.println("Официант попросил убрать со стола");
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }

    }
}
