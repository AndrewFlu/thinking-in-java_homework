package chapters.eleven.containers.map.hashes;

import chapters.containers.countries.Countries;
import net.mindview.containers.MapEntry;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // В качестве размера хеш-таблицы следует выбирать
    // простое число, чтобы обеспечить равномерность распределения:
    static final int SIZE = 997;
    // Физический массив обобщений создать нельзя, но можно
    // прийти к нему через восходящее преобразование
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // заменяем старое значение новым
                System.out.printf("Value for key[%s] has been changed to: %s%n", pair.getKey(), pair.getValue());
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
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();

        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mPair : bucket)
                set.add(mPair);
        }

        return set;
    }

    // test-drive
    public static void main(String[] args) {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.putAll(Countries.countries(10));
        System.out.println(simpleHashMap);
        System.out.println(simpleHashMap.get("HUNGARY"));
        System.out.println(simpleHashMap.entrySet());
    }
}
