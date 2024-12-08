package chapters.fifteen.generics.latent.useadapters;

import utils.Generator;

import java.lang.reflect.InvocationTargetException;

public class Fill2 {

    // версия с маркером
    public static <T> void fill(Addable<T> addable, Class <? extends T> classMarker, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classMarker.getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // версия с генератором
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}
