package chapters.fifteen.generics.generators;

import net.mindview.utils.Generator;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            // предполагается, что type — открытый класс
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // создание генератора по умолчанию для заданного типа
//    public static <T> Generator<T> create(Class<T> type) {
//        return new BasicGenerator<>(type);
//    }
}
