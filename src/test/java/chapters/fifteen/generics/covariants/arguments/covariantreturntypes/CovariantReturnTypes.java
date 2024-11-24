package chapters.fifteen.generics.covariants.arguments.covariantreturntypes;

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived derived = d.get();
    }
}
