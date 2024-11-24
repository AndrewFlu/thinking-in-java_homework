package chapters.fifteen.generics.covariants.arguments.genericandreturntypes;

public interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}
