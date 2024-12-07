package chapters.fifteen.generics.latent.applymethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S sequence, Method method, Object... args) {
        try {
            for (T element : sequence) {
                method.invoke(element, args);
            }
            // Сбои являются ошибками программиста
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
