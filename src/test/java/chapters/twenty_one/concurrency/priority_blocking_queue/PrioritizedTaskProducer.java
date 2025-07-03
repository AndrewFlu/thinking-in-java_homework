package chapters.twenty_one.concurrency.priority_blocking_queue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTaskProducer implements Runnable {

    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec; // используется для EndSentinel
    }

    @Override
    public void run() {
        // Неограниченная очередь; блокировка никогда не происходит.
        // Заполняем случайными приоритетами
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        // Добавляем высокоприоритетные задания
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            // Добавляем задания, начиная с низких приоритетов
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            // Сторож, останавливающий все задачи
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch (InterruptedException ignore) {
            // Допустимый способ выхода
        }
        System.out.println("Finished PrioritizedTaskProducer");
    }
}
