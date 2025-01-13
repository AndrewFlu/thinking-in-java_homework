package chapters.containers.lightweight;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer, String> {
    private final int size;

    public CountingMapData(int size) {
        this.size = Math.max(size, 0);
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        // LinkedHashSet сохраняет порядок иниициализации
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }

        return entries;
    }

    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split("\\s");

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(index);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return
                    chars[index % chars.length] +
                            Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            return "";
        }
    }

    // test-drive
    public static void main(String[] args) {
        System.out.println(new CountingMapData(10));
    }
}
