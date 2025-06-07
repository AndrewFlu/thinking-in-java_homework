package chapters.twenty_one.concurrency.interrupt.check_interrupting_idiom;

import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

public class Blocked3 implements Runnable {

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // точка 1
                NeedsCleanup n1 = new NeedsCleanup(1); // try-finaly сразу за определением n1 для гарантированного закрытия n1
                try {
                    print("Sleeping()");
                    TimeUnit.SECONDS.sleep(1);
                    // точка 2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        print("Calculating");
                        // продолжительная неблокирующая операция
                        for (int i = 0; i < 2_500; i++) {
                            d = d + (Math.PI + Math.E);
                            print("finished time-consuming operation");
                        }
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            print("Exiting via while() test");
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        }
    }
}
