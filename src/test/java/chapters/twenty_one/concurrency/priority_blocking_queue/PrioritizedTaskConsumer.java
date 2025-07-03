package chapters.twenty_one.concurrency.priority_blocking_queue;

import java.util.concurrent.PriorityBlockingQueue;

public class PrioritizedTaskConsumer implements Runnable {

    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
            // для запуска задачи используется текущий поток
                q.take().run();
        } catch (InterruptedException ignore) {
            // Допустимый способ выхода
        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
