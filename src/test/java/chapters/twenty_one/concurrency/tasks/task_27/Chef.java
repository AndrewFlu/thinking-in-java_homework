package chapters.twenty_one.concurrency.tasks.task_27;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;

    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!Thread.interrupted()) {
                while (restaurant.meal != null) { // пока официант занят
                    condition.await(); // ждать, когда заберут блюдо
                }

                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }

                System.out.println("Новый заказ! ");
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        } finally {
            lock.unlock();
        }
    }
}
