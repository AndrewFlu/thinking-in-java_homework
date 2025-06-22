package chapters.twenty_one.concurrency.tasks.task_31;

import java.io.IOException;
import java.util.concurrent.*;

// Args: 0 5 timeout
public class DeadLockingDinningPhilosophers {
    public static void main(String[] args) throws IOException, InterruptedException {

        int pounder = 5;
        if (args.length > 0)
            pounder = Integer.parseInt(args[0]);

        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);

        ExecutorService exec = Executors.newCachedThreadPool();
        // Chopsticks basket
        BlockingQueue<Chopstick> basket = new LinkedBlockingQueue<>();

        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
            basket.put(sticks[i]);
        }

        for (int i = 0; i < size; i++)
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], basket, i, pounder));

        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
