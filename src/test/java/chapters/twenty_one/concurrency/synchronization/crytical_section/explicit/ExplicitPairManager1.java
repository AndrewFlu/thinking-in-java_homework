package chapters.twenty_one.concurrency.synchronization.crytical_section.explicit;

import chapters.twenty_one.concurrency.synchronization.crytical_section.PairManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    //  Синхронизация всего метода
    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}
