package chapters.twenty_one.concurrency.modelling.restaurant;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RestaurantWithQueues {

    public static final int CHEFS_COUNT = 2;
    public static final int WAIT_PERSONS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, CHEFS_COUNT, WAIT_PERSONS_COUNT);
        exec.execute(restaurant);
        if (args.length > 0)
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
