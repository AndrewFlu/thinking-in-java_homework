package chapters.fifteen.generics.covariants.arguments.ordinaryarguments;

import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Derived;

public class DerivedSetter extends OrdinarySetter {
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }
}
