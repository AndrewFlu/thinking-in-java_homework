package chapters.twenty_one.concurrency.tasks.task_11.by_greg;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumRangeChecker implements Runnable {

    private AbstractNumRangeGenerator generator;
    private final int id;

    public NumRangeChecker(int id, AbstractNumRangeGenerator generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void run() {
        System.out.println("Testing NumRangeGenerator...");
        while (!generator.isCanceled()) {
            int[] range = generator.next();
            if (range[0] > range[1])
                System.out.println("Error in test #" + id + ": min (" + range[0] + ") > max (" + range[1] + ")");
            System.out.println("Generated valid range: " + Arrays.toString(range));
            generator.cancel();
        }
    }

    public static void test(AbstractNumRangeGenerator gen, int count) {
        System.out.println("Press Ctrl+C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new NumRangeChecker(i ,gen));
        }
        exec.shutdown();
    }

    public static void test(AbstractNumRangeGenerator gen) {
        test(gen, 10);
    }
}
