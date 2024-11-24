package chapters.fifteen.generics.covariants.arguments.genericandreturntypes;

public class GenericsAndReturnTypes {
    void test(Getter getter) {
        Getter result = getter.get();
        GenericGetter<Getter> baseTypeResult = getter.get();
    }
}
