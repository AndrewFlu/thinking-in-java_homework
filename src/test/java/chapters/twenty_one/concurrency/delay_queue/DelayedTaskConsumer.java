package chapters.twenty_one.concurrency.delay_queue;

import java.util.concurrent.DelayQueue;

class DelayedTaskConsumer implements Runnable {

    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run(); // запуск задачи из текущего потока
        } catch (InterruptedException e) {
            // допустимый способ выхода
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
