package chapters.twenty_one.concurrency.tasks.task_33;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public abstract class AbstractEvent implements Runnable, Delayed {
    protected final long delayTime;
    private long trigger;

    public AbstractEvent(long delayTime) {
        this.delayTime = delayTime;
    }

    public void start() {
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed arg) {
        AbstractEvent that = (AbstractEvent) arg;
        if (trigger < that.trigger)
            return -1;
        if (trigger > that.trigger)
            return 1;
        return 0;
    }

    @Override
    public void run() {

    }
}
