package chapters.eleven.containers.sequence;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    private final List<Object> items = new ArrayList<>();

    public Sequence() {
    }

    public void add(Object x) {
        items.add(x);

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
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size()) i++;
        }
    }
}
