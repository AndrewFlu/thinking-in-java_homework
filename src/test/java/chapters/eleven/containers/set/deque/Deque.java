package chapters.eleven.containers.set.deque;

import java.util.LinkedList;

public class Deque <T> {
    private LinkedList<T> deque = new LinkedList<T>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public void getFirst(T e) {
        deque.getFirst();
    }

    public void getLast() {
        deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
