package chapters.twenty_one.concurrency.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVariableHolder {

    private static final ThreadLocal<Integer> value = ThreadLocal.withInitial(() -> 1);

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executor.execute(new Accessor(i));
        }
        executor.shutdown();
    }
}
