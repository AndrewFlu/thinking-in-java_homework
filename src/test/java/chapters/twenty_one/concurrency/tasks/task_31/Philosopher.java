package chapters.twenty_one.concurrency.tasks.task_31;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

    private Chopstick left, right;
    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);
    private BlockingQueue<Chopstick> basket;

    private void pause() throws InterruptedException {
        if (ponderFactor == 0)
            return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, BlockingQueue<Chopstick> basket, int ident, int ponder) {
        this.left = left;
        this.right = right;
        this.basket = basket;
        id = ident;
        ponderFactor = ponder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking");
                pause();
                // Философ проголодался
                System.out.println(this + " grabbing first, right stick");
                right = basket.take();
                System.out.println(this + " grabbing second, left stick");
                left = basket.take();

                System.out.println(this + " eating");
                pause();
                System.out.println(this + " returning chopsticks to the basket");
                basket.put(right);
                basket.put(left);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    public String toString() {
        return "Philosopher " + id;
    }
}
