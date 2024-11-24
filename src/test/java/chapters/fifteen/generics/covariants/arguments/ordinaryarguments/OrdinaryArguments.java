package chapters.fifteen.generics.covariants.arguments.ordinaryarguments;

import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Base;
import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Derived;

public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();

        DerivedSetter derivedSetter = new DerivedSetter();
        derivedSetter.set(derived);
        // Компилируется, т.к. это перегрузка, не переопределение
        derivedSetter.set(base);
    }
}
