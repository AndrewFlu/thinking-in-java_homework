package chapters.fifteen.generics.instantiate.homework;

import java.lang.reflect.InvocationTargetException;

public class Creator<T> {

    private final Class<T> type;

    public Creator(Class<T> clazz) {
        type = clazz;
    }

    public T create(Integer id, String title) {
        try {
            return type.getConstructor(Integer.class, String.class).newInstance(id, title);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
