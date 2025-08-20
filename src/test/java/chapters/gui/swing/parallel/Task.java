package chapters.gui.swing.parallel;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public void run() {
        System.out.println(this + " started");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
            return;
        }
        System.out.println(this + " completed");
    }

    @Override
    public String toString() {
        return "Task " + id;
    }

    public long id() {
        return id;
    }
}
