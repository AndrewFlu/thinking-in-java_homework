package chapters.fifteen.generics.latent.functional;

// тип объекта-функции
public interface UnaryFunction<R, T> {
    R function (T x);
}
