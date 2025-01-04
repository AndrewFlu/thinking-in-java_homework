package chapters.containers.countries;

import java.util.*;

public class Countries {
    public static final String[][] DATA = {
            // Африка
            {"BULGARIA", "Sofia"},
            {"EGYPT", "Cairo"},
            {"CONGO", "Brazzaville"},

            // Европа
            {"AUSTRIA", "Vienna"},
            {"HUNGARY", "Budapest"},
            {"NORWAY", "Oslo"},

            // Азия
            {"BANGLADESH", "Dhaka"},
            {"CHINA", "Beijing"},
            {"CHINA", "Beijing"},
            {"SAUDI ARABIA", "Riyadh"},

            // Америка
            {"CHILE", "Santiago"},
            {"PERU", "Lima"},
            {"MEXICO", "Mexico City"},
    };

    // Использование AbstractMap реализацией entrySet()
    private static class FlyweightMap extends AbstractMap<String, String> {

        private static class Entry implements Map.Entry<String, String> {
            int index;

            Entry(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        // Использование AbstractSet реализацией size() и iterator()
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private int size;

            EntrySet(int size) {
                if (size < 0)
                    this.size = 0;
                    // не может быть больше массива
                else if (size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }

            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {

                //  Только один объект Entry на Iterator:
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }
        }

        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }
    }

    // Создание частичной карты из 'size' стран:
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> countries() {
        return map; //  Полная карта
    }

    public static Collection<String> capitals() {
        return map.values();
    }

    public static Map<String, String> countries(int size) {
        return select(size);
    }

    public static Collection<String> capitals(int size) {
        return select(size).values();
    }

    static List<String> countryNames = new ArrayList<String>(map.keySet());

    // все имена
    public static List<String> countryNames() {
        return countryNames;
    }

    // Частичный список
    public static List<String> countryNames(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println("countryMap: " + countries());
        CountriesTestDrive.printCountryInfo(countries());
        System.out.println("country names 5: " + countryNames(5));
        System.out.println("HashMap of countryMap 3: " + new HashMap<String, String>(countries(3)));
        System.out.println("LinkedHashMap of countryMap 3: " + new LinkedHashMap<String, String>(countries(3)));
        System.out.println("TreeMap of countryMap 5: " + new TreeMap<String, String>(countries(5)));
        System.out.println("Hashtable of countryMap 3: " + new Hashtable<String, String>(countries(3)));
        System.out.println("LinkedHashSet of country names 5: " + new LinkedHashSet<String>(countryNames(5)));
        System.out.println("TreeSet of country names 5: " + new TreeSet<String>(countryNames(5)));
        System.out.println("ArrayList of country names 5: " + new ArrayList<String>(countryNames(5)));
        System.out.println("LinkedList of country names 5: " + new LinkedList<String>(countryNames(5)));
        System.out.println("a capital of HUNGARY is: " + countries().get("HUNGARY"));
    }
}
