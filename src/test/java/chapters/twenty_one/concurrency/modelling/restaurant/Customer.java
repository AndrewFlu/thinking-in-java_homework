package chapters.twenty_one.concurrency.modelling.restaurant;

import chapters.nineteen.enums.categories.menu.Course;
import chapters.nineteen.enums.categories.menu.Food;

import java.util.concurrent.SynchronousQueue;

class Customer implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private WaitPerson waitPerson;
    // Посетитель может получать тоько одно блюдо за раз:
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customer(WaitPerson waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void deliver(Plate p) throws InterruptedException {
        // Блокируется только в том случае,
        // если посетитель ещё не закончил с предыдущим блюдом:
        placeSetting.put(p);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this, food);
                System.out.println(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + "waiting for " + course + " interrupted");
                break;
            }
        }
        System.out.println(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer " + id + " ";
    }
}
