package chapters.twenty_one.concurrency.deadlocking;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedDinningPhilosophers {
    public static void main(String[] args) throws IOException, InterruptedException {

        int pounder = 5;
        if (args.length > 0)
            pounder = Integer.parseInt(args[0]);

        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();

        for (int i = 0; i < size; i++) {
            if (i < (size - i))
                exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, pounder));
            else
                exec.execute(new Philosopher(sticks[0], sticks[i], i, pounder));
        }

        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press any key to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
