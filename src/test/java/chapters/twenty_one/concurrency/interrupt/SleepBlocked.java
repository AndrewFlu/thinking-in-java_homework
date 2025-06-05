package chapters.twenty_one.concurrency.interrupt;

import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

public class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            print("Interrupted Exception");
        }
        print("Exiting SleepBlocked.run()");
    }
}
