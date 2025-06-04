package chapters.twenty_one.concurrency.tasks.tasks_17;

import java.util.Random;

class RadiationCounter {
    private int count = 0;
    private Random random = new Random();

    // must be synchronized
    public synchronized int increment() {
        return count++;
    }

    // must be synchronized
    public synchronized int value() {
        return count;
    }
}
