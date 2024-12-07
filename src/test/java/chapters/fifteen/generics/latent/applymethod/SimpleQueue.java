package chapters.fifteen.generics.latent.applymethod;

import java.util.Iterator;
import java.util.LinkedList;

// т.к. это очередь, будут применяться методы FIFO
public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<>();

    // first in
    public void add(T t) {
        storage.offer(t);
    }

    // first out
    public T get() {
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
