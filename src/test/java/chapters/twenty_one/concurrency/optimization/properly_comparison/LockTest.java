package chapters.twenty_one.concurrency.optimization.properly_comparison;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockTest extends AbstractAccumulator {

    private Lock lock = new ReentrantLock();

    {
        id = "Lock";
    }

    @Override
    public void accumulate() {
        lock.lock();
        try {
            value += preLoaded[index++];
            if (index >= SIZE)
                index = 0;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long read() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}
