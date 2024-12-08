package chapters.fifteen.generics.latent.useadapters;

import java.util.Collection;

// Вспомогательный класс для автоматической фиксации типа
public class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> collection){
        return new AddableCollectionAdapter<T>(collection);
    }
}
