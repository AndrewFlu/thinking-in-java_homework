package chapters.twenty_one.concurrency.tasks.task_27;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WaitPerson implements Runnable {
    private final Restaurant restaurant;

    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!Thread.interrupted()) {
                while (restaurant.meal == null) {
                    condition.await(); // ожидать, пока повар приготовит блюдо
                }

                System.out.println("Официант получил заказ: " + restaurant.meal);

                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll(); // готов к следующему блюду
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        } finally {
            lock.unlock();
        }
    }
}
