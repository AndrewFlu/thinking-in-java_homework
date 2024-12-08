package chapters.fifteen.generics.latent.functional;

// тип объекта-функции
public interface UnaryPredicate<T> {
    boolean test(T x);
}
