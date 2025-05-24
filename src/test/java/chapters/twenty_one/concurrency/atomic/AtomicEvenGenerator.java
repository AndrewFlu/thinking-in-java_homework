package chapters.twenty_one.concurrency.atomic;

import chapters.twenty_one.concurrency.access_to_resources.EvenChecker;
import chapters.twenty_one.concurrency.access_to_resources.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger currentValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
