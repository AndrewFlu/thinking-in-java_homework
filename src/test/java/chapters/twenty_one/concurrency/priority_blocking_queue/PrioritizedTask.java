package chapters.twenty_one.concurrency.priority_blocking_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random random = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException ignore) {
            // допустимый способ выхода
        }
        System.out.println(this);
    }

    @Override
    public int compareTo(PrioritizedTask arg) {
        return priority < arg.priority
                ? 1
                : (priority > arg.priority ? -1 : 0);
    }

    public String toString() {
        return String.format("[%1$-2d]", priority);
    }

    public String summary() {
        return "(id: " + id + " || priority: " + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSentinel(ExecutorService e) {
            super(-1); // самый низкий приоритет в программе
            exec = e;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                System.out.println(pt.summary());
                if (++count % 5 == 0)
                    System.out.println();
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
