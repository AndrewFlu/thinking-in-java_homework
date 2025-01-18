package chapters.containers.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SList<T> {
    private Link<T> first;
    private long size;

    SListIterator iterator() {
        return new SListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SListIterator iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(", ");
        }

        if (sb.isEmpty()) {
            return "[]";
        } else {
            sb.insert(0, "[");
            sb.replace(sb.length() - 2, sb.length(), "");
            sb.append("]");
        }

        return sb.toString();
    }

    private class SListIterator implements Iterator<T> {
        private long index;
        private Link<T> current;
        private Link<T> previous;

        public SListIterator() {
            this.current = first;
        }

        public void add(T value) {
            if (first == null) {
                first = new Link<>(value);
                size++;
            } else {
                Link<T> next = first.next;
                Link<T> target = first;
                while (next != null) {
                    target = next;
                    next = next.next;
                }

                target.next = new Link<>(value);
                size++;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            previous = current;
            current = current.next;
            index++;

            return previous.value;
        }

        @Override
        public void remove() {
            Link<T> next = first;
            while(next != null) {
                if (next.next == previous) {
                    next.next = null;
                    size--;
                    break;
                }

                next = next.next;
            }
        }
    }

    private static class Link<E> {
        private E value;
        private Link<E> next;

        public Link(E value) {
            this.value = value;
        }


    }

    // test-drive
    public static void main(String[] args) {
        SList<String> sList = new SList<>();
        SList<String>.SListIterator iterator = sList.iterator();

        iterator.add("one");
        iterator.add("two");
        iterator.add("three");

        System.out.println(sList);
        iterator.remove();
        System.out.println(sList);
    }
}
