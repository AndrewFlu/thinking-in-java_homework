package net.mindview.containers;

import java.util.Map;

public class LinkedMapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    private LinkedMapEntry<K, V> nextEntry = null;

    public LinkedMapEntry(K key, V value) {
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
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public LinkedMapEntry<K, V> getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(LinkedMapEntry<K, V> nextEntry) {
        this.nextEntry = nextEntry;
    }

    @Override
    public boolean equals(Object arg) {
        if (!(arg instanceof LinkedMapEntry))
            return false;
        LinkedMapEntry mEntry = (LinkedMapEntry) arg;
        return
                (key == null ? mEntry.getKey() == null : key.equals(mEntry.getKey())) &&
                        (value == null ? mEntry.getValue() == null : value.equals(mEntry.getValue()));
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
