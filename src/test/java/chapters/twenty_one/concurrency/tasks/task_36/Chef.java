package chapters.twenty_one.concurrency.tasks.task_36;

import chapters.nineteen.enums.categories.menu.Food;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Chef implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокируется до появления заказа:
                OrderTicket order = restaurant.orders.take();
                Food requestedItem = order.item();
                // Время на подготовку заказа:
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + "прерван");
        }
        System.out.println(this + "вне рабочих обязанностей");
    }

    @Override
    public String toString() {
        return "Шеф-повар " + id + " ";
    }
}
