package chapters.seventeen.containers;

import chapters.containers.countries.Countries;
import chapters.containers.generators.MapData;
import chapters.sixteen.arrays.generators.RandomGenerator;
import net.mindview.containers.MapEntry;

import java.util.*;

public class SimpleHashMapWithRehashes<K, V> extends AbstractMap<K, V> {
    // Choose the prime number for the hashtable size
//    to achieve a uniform distribution
    static final int SIZE = 997;
    // capacity field starts equal to SIZE
    private int capacity = SIZE;
    // you can't have a physical array of generics,
    // but you can upcast to one:
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public int getCapacity() {
        return capacity;
    }

    // method to appropriately increase capacity
    // and refill the new buckets with the old data:
    private void rehash() {
        capacity = Prime.firstPrimeAfter(capacity * 2);
        LinkedList<MapEntry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        for (LinkedList<MapEntry<K, V>> bucket : oldBuckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> entry : bucket)
                this.put(entry.getKey(), entry.getValue());
        }
    }

    public V put(K key, V value) {
        // Check and call rehash() if needed:
        if (this.size() > 0.75 * capacity)
            rehash();
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();

        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);

        boolean found = false;
        ListIterator<MapEntry<K, V>> listIterator = bucket.listIterator();
        while (listIterator.hasNext()) {
            MapEntry<K, V> next = listIterator.next();
            if (next.getKey().equals(key)) {
                oldValue = next.getValue();
                listIterator.set(next); // replace old with new
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);

        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MapEntry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> entry : bucket)
                set.add(entry);
        }
        return set;
    }

    // Helper class to find prime number after an int:
    private static class Prime {
        public static int firstPrimeAfter(int n) {
            for (int i = n + 1; i > n; i++) {
                int factor = 0;
                for (int j = 1; j < (i + 2) / 2; j++) {
                    if ((i % j) == 0)
                        factor++;
                }
                if (factor < 2)
                    return i;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        RandomGenerator.Integer rgi = new RandomGenerator.Integer(10_000);
        System.out.println("Testing map m of <String, String>. The basics: ");
        SimpleHashMapWithRehashes<String, String> m = new SimpleHashMapWithRehashes<>();
        m.putAll(Countries.countries(10));
        System.out.println("m: " + m);
        System.out.println("m.get(CONGO): " + m.get("CONGO"));
        System.out.println("m.size(): " + m.size());
        System.out.println("m.capacity(): " + m.getCapacity());

        System.out.println("Testing rehash() for a map m2 of <Integer, Integer>:");
        SimpleHashMapWithRehashes<Integer, Integer> m2 = new SimpleHashMapWithRehashes<>();
        System.out.println("m2: " + m2);
        System.out.println("m2.size(): " + m2.size());
        System.out.println("m2.capacity(): " + m2.getCapacity());
        System.out.println();

        m2.putAll(MapData.map(rgi, rgi, 996));
        System.out.println("after m2.putAll(MapData.map(rgi, rgi, 996): ");
        System.out.println("m2.size(): " + m2.size());
        System.out.println("m2.capacity(): " + m2.getCapacity());
        System.out.println();

        m2.putAll(MapData.map(rgi, rgi, 2_000));
        System.out.println("after m2.putAll(MapData.map(rgi, rgi, 2000): ");
        System.out.println("m2.size(): " + m2.size());
        System.out.println("m2.capacity(): " + m2.getCapacity());
        System.out.println();

        m2.putAll(MapData.map(rgi, rgi, 1_500));
        System.out.println("after m2.putAll(MapData.map(rgi, rgi, 1500): ");
        System.out.println("m2.size(): " + m2.size());
        System.out.println("m2.capacity(): " + m2.getCapacity());
        System.out.println();
    }
}
