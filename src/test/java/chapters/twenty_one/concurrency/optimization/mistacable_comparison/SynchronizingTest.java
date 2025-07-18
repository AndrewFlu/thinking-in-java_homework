package chapters.twenty_one.concurrency.optimization.mistacable_comparison;

public class SynchronizingTest extends AbstractIncrementable {

    @Override
    public synchronized void increment() {
        ++counter;
    }
}
