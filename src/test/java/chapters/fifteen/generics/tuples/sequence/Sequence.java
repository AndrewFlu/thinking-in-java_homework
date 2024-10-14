package chapters.fifteen.generics.tuples.sequence;

public class Sequence<T> {
    private final T[] items;
    private int next = 0;

    @SuppressWarnings("unchecked")
    public Sequence(int size) {
        items = (T[])new Object[size];
    }

    public void add(T x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector<T> selector() {
        return new SequenceSelector();
    }

    public Sequence<T> sequenceSelector() {
        return this.new SequenceSelector().getSequence();
    }

    private class SequenceSelector implements Selector<T> {
        private int i = 0;

        public Sequence<T> getSequence() {
            return Sequence.this; // возвращает ссылку на внешний класс
        }

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public T current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }
}
