package chapters.eleven.containers.map.slowmap;

import net.mindview.containers.MapEntry;

import java.util.*;

public class SlowMapWithModifiedPut<K, V> extends SlowMapWithOneArray<K, V>{
    // To allow search for key via Collections.binarySearch(List<T>, T, Comparator):
    private List<MapEntry<Integer, V>> hashEntryList = new ArrayList<>();
    public List<MapEntry<Integer, V>> hashEntryList() {
        return hashEntryList;
    }
    // To allow sorting
    private final MapEntryKeyComp<K, V> comp1 = new MapEntryKeyComp<K, V>();
    private final MapEntryKeyComp<Integer, V> comp2 = new MapEntryKeyComp<Integer, V>();

    // Very slow put() with 2 sorts:
    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        Iterator<MapEntry<K, V>> iterator = entryList.iterator();
        while(iterator.hasNext()) {
            MapEntry<K, V> next = iterator.next();
            if (next.getKey().equals(key))
                next.setValue(value);
        }
        entryList.add(new MapEntry<>(key, value));
        hashEntryList.add(new MapEntry<Integer, V>(key.hashCode(), value));
        // Sort after adding (uses hashCode())
        Collections.sort(entryList, comp1);
        Collections.sort(hashEntryList, comp2);
        return oldValue;
    }

    // Faster get() with sorting done in put()
    @Override
    public V get(Object key) {
        // Same key, same hashCode via MapEntryKeyComp<K, V>:
        MapEntry<Integer, V> sub = new MapEntry<>(key.hashCode(), null);
        int i = Collections.binarySearch(hashEntryList, sub, comp2);
        if (i >= 0 )
            return hashEntryList.get(i).getValue();
        return null;
    }

    // Sort by key hashCode()
    private class MapEntryKeyComp<K, V> implements Comparator<MapEntry<K, V>> {

        @Override
        public int compare(MapEntry<K, V> o1, MapEntry<K, V> o2) {
            return o1.getKey().hashCode() - o2.getKey().hashCode();
        }
    }
}
