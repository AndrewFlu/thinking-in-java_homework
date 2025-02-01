package chapters.sixteen.arrays.generators;

import net.mindview.utils.Generator;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionData<T> {
    private Collection<T> collection;
    private Generator<T> generator;
    private int size;

    public CollectionData(Generator<T> generator, int size) {
        this.generator = generator;
        this.size = size;
        fillCollection();
    }

    private void fillCollection() {
        collection = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
    }

    public T[] toArray(T[] a) {
        return collection.toArray(a);
    }
}
