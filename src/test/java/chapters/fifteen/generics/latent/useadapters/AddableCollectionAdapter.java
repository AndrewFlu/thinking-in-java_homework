package chapters.fifteen.generics.latent.useadapters;

import java.util.Collection;

// Для адаптации базового типа необходимо использовать композицию.
// Включение поддержки Addable в произвольный контейнер Collection
// с использованием композиции:
public class AddableCollectionAdapter<T> implements Addable<T> {
    private final Collection<T> collection;

    public AddableCollectionAdapter(Collection<T> collection) {
        this.collection = collection;
    }

    public void add(T element) {
        collection.add(element);
    }
}
