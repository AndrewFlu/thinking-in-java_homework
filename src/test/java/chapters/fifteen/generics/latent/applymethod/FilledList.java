package chapters.fifteen.generics.latent.applymethod;

import java.util.ArrayList;

public class FilledList <T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++) {
                // предполагается конструктор по умолчанию
                add(type.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
