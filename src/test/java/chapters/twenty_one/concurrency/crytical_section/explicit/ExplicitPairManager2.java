package chapters.twenty_one.concurrency.crytical_section.explicit;

import chapters.twenty_one.concurrency.crytical_section.Pair;
import chapters.twenty_one.concurrency.crytical_section.PairManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
