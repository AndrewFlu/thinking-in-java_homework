package chapters.eleven.containers.list.iterator.sequence;

import java.util.Arrays;
import java.util.Iterator;

public class Sequence implements Selector{
    private final Object[] items;
    private final Iterator iterator;
    private int currentIndex = 0;

    public Sequence(int size) {
        items = new Object[size];
        iterator = Arrays.stream(items).iterator();
    }

    public void add(Object x) {
        if (currentIndex < items.length) {
            items[currentIndex++] = x;
        }
    }

    @Override
    public boolean end() {
        return !iterator.hasNext();
    }

    @Override
    public Object current() {
        return iterator.next();
    }

    @Override
    public void next() {
    }
}
