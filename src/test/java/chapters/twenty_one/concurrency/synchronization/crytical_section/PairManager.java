package chapters.twenty_one.concurrency.synchronization.crytical_section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Защита Pair в потоково-безопасном классе
public abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private final List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        // создание копии для защиты оригинала:
        return new Pair(p.getX(), p.getY());
    }

    // Предполагается, что эта операция занимает много времени
    protected synchronized void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {
        }
    }

    public abstract void increment();

}
