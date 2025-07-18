package chapters.twenty_one.concurrency.optimization.mistacable_comparison;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingTest extends AbstractIncrementable {

    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}
