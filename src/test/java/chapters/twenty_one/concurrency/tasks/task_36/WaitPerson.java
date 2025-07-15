package chapters.twenty_one.concurrency.tasks.task_36;

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

    public void placeOrder(Customer cust, Food food, Table table) {
        try {
            // этот вызов не должен блокироваться,
            // т.к. LinkedBlockingQueue не имеет ограничений по размеру:
            restaurant.orders.put(new OrderTicket(cust, this, food, table));
        } catch (InterruptedException e) {
            System.out.println(this + " размещение заказа прервано");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокирутеся, пока блюдо не будет готово
                Plate plate = filledOrders.take();
                System.out.println(this + "получил " + plate + ", доставляет до " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " прерван");
        }
        System.out.println(this + " вне рабочих обязанностей");
    }

    @Override
    public String toString() {
        return "Официант " + id + " ";
    }
}
