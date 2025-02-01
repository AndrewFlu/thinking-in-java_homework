package chapters.sixteen.arrays.generators;

import net.mindview.utils.Generator;

import java.lang.reflect.Array;

public class Generated {
    // Заполнение существующего массива
    public static <T> T[] array(T[] a, Generator<T> generator) {
        return new CollectionData<T>(generator, a.length).toArray(a);
    }

    // Создание нового массива
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> generator, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(generator, size).toArray(a);
    }
}
