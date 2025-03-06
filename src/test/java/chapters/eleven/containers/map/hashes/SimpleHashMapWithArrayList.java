package chapters.eleven.containers.map.hashes;

import chapters.containers.countries.Countries;
import net.mindview.containers.MapEntry;

import java.sql.Array;
import java.util.*;

public class SimpleHashMapWithArrayList<K, V> extends AbstractMap<K, V> {
    // В качестве размера хеш-таблицы следует выбирать
    // простое число, чтобы обеспечить равномерность распределения:
    static final int SIZE = 997;
    // Физический массив обобщений создать нельзя, но можно
    // прийти к нему через восходящее преобразование
    ArrayList<MapEntry<K, V>>[] buckets = new ArrayList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        boolean hasCollision = false;

        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new ArrayList<MapEntry<K, V>>();
        else
            hasCollision = true;

        ArrayList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();

            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // заменяем старое значение новым
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        if (hasCollision) {
            String collisionMessage = String.format("Collision while adding [%s] with [%d] elements: %s", pair, buckets[index].size(), buckets[index]);
            System.out.println(collisionMessage);
        }

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
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mPair : bucket)
                set.add(mPair);
        }
        return set;
    }

    @Override
    public void clear() {
        buckets = new ArrayList[SIZE];
    }

    @Override
    public V remove(Object key) {
        if (containsKey(key)) {
            int index = Math.abs(key.hashCode()) % SIZE;
            ArrayList<MapEntry<K, V>> bucketElements = buckets[index];
            for (MapEntry<K, V> entry : bucketElements) {
                if (entry.getKey().equals(key)) {
                    bucketElements.remove(entry);
                    return entry.getValue();
                }
            }
        }

        throw new NullPointerException("The key is not found: " + key);
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V result = get(key);
        return result == null ? defaultValue : result;
    }

    // test-drive
    public static void main(String[] args) {
        SimpleHashMapWithArrayList<String, String> simpleHashMap = new SimpleHashMapWithArrayList<>();
        simpleHashMap.putAll(Countries.countries(10));
        System.out.println(simpleHashMap);
        System.out.println(simpleHashMap.get("HUNGARY"));
    }
}
