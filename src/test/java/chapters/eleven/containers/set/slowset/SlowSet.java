package chapters.eleven.containers.set.slowset;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SlowSet <T> extends AbstractSet<T> {
    private List<T> elements = new ArrayList<>();

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }

            @Override
            public void remove() {
                elements.remove(--index);
            }
        };
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean add(T arg) {
        final boolean contains = elements.contains(arg);
        if (!contains)
            elements.add(arg);

        return !contains;
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }
}
