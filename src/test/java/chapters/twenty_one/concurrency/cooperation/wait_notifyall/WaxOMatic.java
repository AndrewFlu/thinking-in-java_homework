package chapters.twenty_one.concurrency.cooperation.wait_notifyall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new WaxOff(car));
        executor.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(2); // поработать некоторое время
        executor.shutdownNow(); // прервать все задачи
    }
}
