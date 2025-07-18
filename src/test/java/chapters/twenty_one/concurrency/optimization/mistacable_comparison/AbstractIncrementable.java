package chapters.twenty_one.concurrency.optimization.mistacable_comparison;

import java.util.concurrent.locks.Lock;

abstract class AbstractIncrementable {
    protected long counter = 0;
    public abstract void increment();
}
