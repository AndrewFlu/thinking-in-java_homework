package chapters.twenty_one.concurrency.daemons;

import chapters.twenty_one.concurrency.priority.SimplePriorities;

import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Необходимо вызвать перед start()
            daemon.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(120);
    }
}
