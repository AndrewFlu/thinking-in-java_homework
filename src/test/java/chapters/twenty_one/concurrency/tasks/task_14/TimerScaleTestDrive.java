package chapters.twenty_one.concurrency.tasks.task_14;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerScaleTestDrive implements Runnable {
    private static final long TIMEOUT = 0;
    private static int timers = 0;
    private static int tasks = 0;


    @Override
    public void run() {
        try {
            while (timers < 1_500) {// create 1500 timers
                ++timers;
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ++tasks;
                        if (timers % 100 == 0)
                            System.out.println(timers + " timers did " + tasks + " tasks");
                    }
                }, TIMEOUT);

                try {
                    TimeUnit.MILLISECONDS.sleep(10); // time to do task
                } catch (InterruptedException e) {
                    System.out.println("Sleep interrupted");
                }
                timer.cancel();
            }

        } finally {
            System.out.println("Done. " + timers + " timers completed " + tasks + " tasks");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new TimerScaleTestDrive());
        exec.shutdown();
    }
}
