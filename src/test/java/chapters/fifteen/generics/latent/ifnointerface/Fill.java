package chapters.fifteen.generics.latent.ifnointerface;

import java.util.Collection;

public class Fill {
    public static <T> void fill(Collection<T> collection, Class<? extends T> clazz, int size) {
        for (int i = 0; i < size; i++) {
            try {
                collection.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
