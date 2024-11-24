package chapters.fifteen.generics.covariants.arguments.plaingenericinheritance;

import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Base;
import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Derived;

public class DerivedGenericSetter extends GenericSetter<Base> {
    void set(Derived derived) {
        System.out.println("DerivedGenericSetter.set(Derived)");
    }
}
