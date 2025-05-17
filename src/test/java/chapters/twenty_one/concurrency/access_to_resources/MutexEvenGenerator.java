package chapters.twenty_one.concurrency.access_to_resources;

import com.sun.source.doctree.TextTree;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        // идиома: после lock() всегда должна идти секция try-finally,
        // чтобы гарантировать освобождение блокировки в любом случае
        try {
            ++currentEvenValue;
            Thread.yield(); // Повышение вероятности ошибки
            ++currentEvenValue;

            return currentEvenValue; // return — гарантирует, что команда unlock() не будет выполнена слишком рано
            // и данные не станут доступными для другой задачи
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
