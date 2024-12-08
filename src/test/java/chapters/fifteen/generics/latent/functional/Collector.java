package chapters.fifteen.generics.latent.functional;

// тип объекта-функции
public interface Collector<T> extends UnaryFunction<T, T> {
    T result(); // извлечение результата из парметра-накопителя
}
