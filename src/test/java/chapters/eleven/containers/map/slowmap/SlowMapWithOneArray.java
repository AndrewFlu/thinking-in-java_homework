package chapters.eleven.containers.map.slowmap;

import chapters.containers.countries.Countries;
import net.mindview.containers.MapEntry;

import java.util.*;

public class SlowMapWithOneArray<K, V> extends AbstractMap<K, V> {

    protected List<MapEntry<K, V>> entryList = new ArrayList<>();

    private EntrySet entries = new EntrySet();

    public Set<Map.Entry<K, V>> entrySet() {
        return entries;
    }

    public V put(K key, V value) {
        V oldValue = get(key); // Старое значение или null
        Iterator<MapEntry<K, V>> it = entryList.iterator();
        while (it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if (me.getKey().equals(key))
                me.setValue(value);
        }
        entryList.add(new MapEntry<>(key, value));

        return oldValue;
    }

    public V get(Object key) { // k — относится к типу Object, а не к K
        Iterator<MapEntry<K, V>> it = entryList.iterator();
        while(it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if (me.getKey().equals(key))
                return me.getValue();
        }
        return null;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public int size() {
            return entryList.size();
        }


        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < entryList.size() - 1;
                }

                @Override
                public Entry<K, V> next() {
                    int i = ++index;
                    return entryList.get(i);
                }

                @Override
                public void remove() {
                    entryList.remove(index--);
                }
            };
        }

    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.countries());

        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
