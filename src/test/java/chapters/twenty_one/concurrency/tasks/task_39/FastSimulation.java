package chapters.twenty_one.concurrency.tasks.task_39;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FastSimulation {
    static final int N_ELEMENTS = 100_000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS = 50;
    static final int[][] GRID = new int[N_ELEMENTS][N_GENES];
    static Random rand = new Random(47);

    static class Evolver implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                // Случайный выбор элемента
                int element = rand.nextInt(N_ELEMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int previous = element - 1;
                    if (previous < 0)
                        previous = N_ELEMENTS - 1;
                    int next = element + 1;
                    if (next >= N_ELEMENTS)
                        next = 0;
                    int oldValue;
                    Lock l = new ReentrantLock();
                    l.lock();
                    try {
                        oldValue = GRID[element][i];
                    } finally {
                        l.unlock();
                    }
                    // Модель вычислений
                    int newValue = oldValue + GRID[previous][i];
                    newValue /= 3; // Вычисление среднего по 3 значениям
                    if (GRID[element][i] != oldValue) {
                        // Наша задача — решить, как обработать ошибку.
                        // Здесь мы сообщаем о ней и игнорируем;
                        // наша модель справится с этой проблемой
                        System.out.println("Old value changed from " + oldValue);
                    } else {
                        Lock lock = new ReentrantLock();
                        lock.lock();
                        try {
                            GRID[element][i] = newValue;
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENTS; i++)
            for (int j = 0; j < N_GENES; j++)
                GRID[i][j] = rand.nextInt(1_000);

        for (int i = 0; i < N_EVOLVERS; i++)
            exec.execute(new Evolver());

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
