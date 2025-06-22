package chapters.twenty_one.concurrency.tasks.task_32;

import java.util.Random;

class Count {
    private int count = 0;
    private Random random = new Random(47);

    // удаляем ключевое слово synchronized, чтобы увидеть сбой в системе подсчёта
    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) // уступает управление
            Thread.yield(); // в половине случаев
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}
