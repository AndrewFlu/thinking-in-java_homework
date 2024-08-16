package chapters.ten.multiimplementation.sequence;

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {return new ReverseSelector();}

    public Sequence sequenceSelector() {
        return this.new SequenceSelector().getSequence();
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public Sequence getSequence() {
            return Sequence.this; // возвращает ссылку на внешний класс
        }

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    private class ReverseSelector implements Selector {
        private int j = items.length;
        @Override
        public boolean end() {
            return j == 0;
        }

        @Override
        public Object current() {
            return items[j - 1];
        }

        @Override
        public void next() {
            if (j > 0) j--;
        }
    }
}
