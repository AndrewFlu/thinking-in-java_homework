package chapters.eleven.containers.collectionanditerator;

import chapters.eleven.containers.collectionanditerator.pets.Pet;
import chapters.eleven.containers.collectionanditerator.pets.Pets;

import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence implements Collection {
    private Pet[] pets = Pets.createArray(8);
    private int index = 0;

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public boolean isEmpty() {
        return index < pets.length;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Object next() {
                return pets[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return pets;
    }

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }
}
