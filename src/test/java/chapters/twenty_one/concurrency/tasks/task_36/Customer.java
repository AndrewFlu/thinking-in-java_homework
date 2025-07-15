package chapters.twenty_one.concurrency.tasks.task_36;

import chapters.nineteen.enums.categories.menu.Course;
import chapters.nineteen.enums.categories.menu.Food;

import java.util.concurrent.SynchronousQueue;

class Customer implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private WaitPerson waitPerson;
    private Table table;
    // Посетитель может получать тоько одно блюдо за раз:
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customer(WaitPerson waitPerson, Table table) {
        this.waitPerson = waitPerson;
        this.table = table;
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
                waitPerson.placeOrder(this, food, table);
                System.out.println(this + "ест " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + ", ожидающий " + course + " прерван");
                break;
            }
        }
        System.out.println(this + "покушал. Уходит");
    }

    @Override
    public String toString() {
        return "Клиент " + id + " ";
    }
}
