package chapters.twelve.exceptions.sequence;

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) throws ArrayIndexOutOfBoundsException {
        if (next < items.length) {
            items[next++] = x;
        } else {
            throw new ArrayIndexOutOfBoundsException("Немецких машин только 3 вида. Опель — не машина");
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

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
}
