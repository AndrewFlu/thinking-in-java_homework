package chapters.twenty_one.concurrency.tasks.task_9;

import java.util.Random;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

    private Random random = new Random();

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread();
        int priority = random.nextInt(3);
        switch (priority) {
            case 0:
                t.setPriority(Thread.MIN_PRIORITY);
            case 1:
                t.setPriority(Thread.NORM_PRIORITY);
            case 2:
                t.setPriority(Thread.MAX_PRIORITY);
            default:
        }

        return t;
    }
}
