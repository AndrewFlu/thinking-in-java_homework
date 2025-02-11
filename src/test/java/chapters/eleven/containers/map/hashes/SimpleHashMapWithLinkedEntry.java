package chapters.eleven.containers.map.hashes;

import chapters.containers.countries.Countries;
import net.mindview.containers.LinkedMapEntry;
import net.mindview.containers.MapEntry;

import java.util.*;

public class SimpleHashMapWithLinkedEntry <K, V> extends AbstractMap<K, V> {

    private static final int SIZE = 997;
    LinkedList<LinkedMapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        LinkedMapEntry<K, V> pair = new LinkedMapEntry<>(key, value);
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<LinkedMapEntry<K, V>>();
            LinkedList<LinkedMapEntry<K, V>> bucket = buckets[index];
            bucket.add(pair);
        }

        LinkedList<LinkedMapEntry<K, V>> bucket = buckets[index];
        if (buckets[index].size() > 0) {
            for (LinkedMapEntry<K, V> entry = bucket.get(0); entry != null; entry = entry.getNextEntry()) {
                if (entry.getKey().equals(key)) {
                    oldValue = entry.getValue();
                    entry.setValue(value);

                    return oldValue;
                }
            }

            bucket.add(pair);
            int i = bucket.indexOf(pair);
            if (i > 0) bucket.get(i - 1).setNextEntry(pair);

            return pair.getValue();
        }

        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (LinkedMapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        }

        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<LinkedMapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (LinkedMapEntry<K, V> mPair : bucket) {
                set.add(mPair);
            }
        }

        return set;
    }

    // test-drive
    public static void main(String[] args) {
        SimpleHashMapWithLinkedEntry<String, String> map = new SimpleHashMapWithLinkedEntry<>();
        map.putAll(Countries.countries(5));

        System.out.println(map);
        map.put("SERBIA" ,"Oslo?");
        map.put("SERBIA", "Belgrad");

        System.out.println("Serbia: " + map.get("SERBIA"));
        System.out.println(map.entrySet());
    }
}
