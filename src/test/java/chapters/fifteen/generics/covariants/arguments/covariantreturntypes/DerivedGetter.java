package chapters.fifteen.generics.covariants.arguments.covariantreturntypes;

public interface DerivedGetter extends OrdinaryGetter {
    // Возвращаемый тип переопределённого метода может изменяться:
    Derived get();
}
