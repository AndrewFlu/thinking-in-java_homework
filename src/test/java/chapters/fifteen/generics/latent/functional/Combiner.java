package chapters.fifteen.generics.latent.functional;

// тип объекта-функции
public interface Combiner<T> {
    T combine(T x, T y);
}
