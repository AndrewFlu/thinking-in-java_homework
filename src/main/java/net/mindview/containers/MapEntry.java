package net.mindview.containers;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = value;
        this.value = value;

        return oldValue;
    }

    @Override
    public boolean equals(Object arg) {
        if (!(arg instanceof MapEntry))
            return false;
        MapEntry entry = (MapEntry) arg;
        return (key == null ? entry.getKey() == null : key.equals(entry.getKey())) &&
                (value == null ? entry.getValue() == null : value.equals(entry.getValue()));
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
