package chapters.twenty_one.concurrency.optimization.properly_comparison;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class AtomicTest extends AbstractAccumulator {

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    {
        id = "Atomic";
    }

    @Override
    public void accumulate() {
        // решение не может использовать сразу несколько
        // объектов Atomic. Тем не менее оно даёт
        // представление о производительности
        int i = index.getAndIncrement();
        value.getAndAdd(preLoaded[i]);
        if (++i >= SIZE)
            index.set(0);
    }

    @Override
    public long read() {
        return value.get();
    }
}
