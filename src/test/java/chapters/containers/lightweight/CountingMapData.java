package chapters.containers.lightweight;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer, String> {
    private static final String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split("\\s");
    private final int size;
    private final Set<Map.Entry<Integer, String>> entries = new InnerEntrySet();

    public CountingMapData(int size) {
        this.size = Math.max(size, 0);
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return entries;
    }

    private static class InnerEntry implements Map.Entry<Integer, String> {
        int index;

        public InnerEntry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof InnerEntry &&
                    index == ((InnerEntry) o).index;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return
                    chars[index % chars.length] +
                            index / chars.length;
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }

    // Т.к. мы расширяем уже базовый абстрактный класс, то реализовать нам нужно всего два метода: size и iterator
    private class InnerEntrySet extends AbstractSet<Map.Entry<Integer, String>> {

        @Override
        public int size() {
            return size;
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new InnerIterator();
        }

        private class InnerIterator implements Iterator<Map.Entry<Integer, String>> {

            // Только один объект Entry на итератор
            private InnerEntry innerEntry = new InnerEntry(-1);

            @Override
            public boolean hasNext() {
                return innerEntry.index < size - 1;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                innerEntry.index++;

                return innerEntry;
            }
        }
    }


    // test-drive
    public static void main(String[] args) {
        System.out.println(new CountingMapData(100));
    }
}
