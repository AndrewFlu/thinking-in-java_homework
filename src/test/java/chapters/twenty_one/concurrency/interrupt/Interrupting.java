package chapters.twenty_one.concurrency.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static net.mindview.utils.Print.print;

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> future = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(10);
        print("Interrupting " + r.getClass().getSimpleName());
        future.cancel(true); // прервать, если выполняется
        print("Interrupt sent to " + r.getClass().getSimpleName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());

        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0); // т.к. два предыдущих прерывания завершились неудачей
    }
}
