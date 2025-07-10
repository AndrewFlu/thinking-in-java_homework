package chapters.twenty_one.concurrency.modelling.restaurant;

import chapters.nineteen.enums.categories.menu.Food;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class WaitPerson implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrder(Customer cust, Food food) {
        try {
            // этот выхов не должен блокироваться,
            // т.к. LinkedBlockingQueue не имеет ограничений по размеру:
            restaurant.orders.put(new Order(cust, this, food));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирутеся, пока блюдо не будет готово
                Plate plate = filledOrders.take();
                System.out.println(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson " + id + " ";
    }
}
