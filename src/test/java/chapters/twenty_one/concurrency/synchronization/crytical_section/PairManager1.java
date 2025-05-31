package chapters.twenty_one.concurrency.synchronization.crytical_section;

// Синхронизация целого метода
public class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
