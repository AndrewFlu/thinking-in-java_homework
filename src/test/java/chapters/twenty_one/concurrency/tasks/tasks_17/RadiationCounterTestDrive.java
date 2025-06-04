package chapters.twenty_one.concurrency.tasks.tasks_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

public class RadiationCounterTestDrive {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.execute(new Sensor(i));
        }
        // let run program for a while and then stop the program
        TimeUnit.SECONDS.sleep(1);
        Sensor.cancel();
        executor.shutdown();
        if (!executor.awaitTermination(300, TimeUnit.MILLISECONDS)) {
            print("Some tasks were not terminated!");
        }
        print("Total: " + Sensor.getTotalCount());
        print("Sum of Sensors: " + Sensor.getSumOfSensors());
    }
}
