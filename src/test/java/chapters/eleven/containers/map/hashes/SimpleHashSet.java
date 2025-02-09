package chapters.eleven.containers.map.hashes;

import chapters.containers.countries.Countries;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleHashSet<T> extends AbstractSet<T> {
    private static final int SIZE = 997;
    private LinkedList<T>[] buckets = new LinkedList[SIZE];

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            int bucketNumber;
            int indexIntoBucket;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                index++;
                while (bucketNumber < SIZE && buckets[bucketNumber] == null) {
                    bucketNumber++;
                }

                try {
                    return buckets[bucketNumber].get(indexIntoBucket++);
                } catch (IndexOutOfBoundsException ignore) {
                    bucketNumber--;
                    indexIntoBucket = 0;
                }

                return null;
            }

            @Override
            public void remove() {
                LinkedList<T> bucket = buckets[bucketNumber];
                bucket.remove(--indexIntoBucket);
                if (bucket.isEmpty())
                    buckets[bucketNumber] = null;

                index--;
            }
        };
    }

    @Override
    public int size() {
        int result = 0;
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                result += bucket.size();
            }
        }

        return result;
    }

    @Override
    public boolean add(T t) {
        int index = Math.abs(t.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();

        final LinkedList<T> bucket = buckets[index];
        if (bucket.contains(t))
            return false;
        bucket.add(t);

        return true;
    }

    // test-drive
    public static void main(String[] args) {
        SimpleHashSet<String> set = new SimpleHashSet<>();
        Collection<String> capitals = Countries.capitals();
        System.out.println("Capitals: " + capitals);
        set.addAll(capitals);
        System.out.println("Set: " + set);
        boolean added = set.add("Riyadh");
        System.out.println("added? " + added);
        boolean added2 = set.add("Dubrovnik");
        System.out.println("added2? " + added2);
        System.out.println(set);
    }
}
