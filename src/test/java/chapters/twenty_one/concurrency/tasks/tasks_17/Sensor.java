package chapters.twenty_one.concurrency.tasks.tasks_17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

class Sensor implements Runnable {

    private static RadiationCounter radiationCounter = new RadiationCounter();

    private static List<Sensor> sensors = new ArrayList<>();
    private int sensorCounter = 0;

    // doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;

    // Atomic operation on a volatile field:
    public static void cancel() {
        canceled = true;
    }

    public Sensor(int id) {
        this.id = id;
        // keep this task in a list
        // Also prevents garbage collection of dead tasks
        sensors.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++sensorCounter;
            }
            print(this + " Total: " + radiationCounter.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                print("sleep() interrupted");
            }
        }
        print("Stopping " + this);
    }

    public String toString() {
        return "Sensor #" + id + ": " + getValue();
    }

    private int getValue() {
        return sensorCounter;
    }

    public static int getSumOfSensors() {
        int res = 0;
        for (Sensor sensor : sensors)
            res += sensor.getValue();
        return res;
    }

    public static int getTotalCount() {
        return radiationCounter.value();
    }
}
