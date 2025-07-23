package chapters.twenty_one.concurrency.optimization.properly_comparison;

class SynchronizedTest extends AbstractAccumulator {

    {
        id = "Synchronized";
    }

    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE)
            index = 0;
    }

    @Override
    public synchronized long read() {
        return value;
    }
}
