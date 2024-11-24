package chapters.fifteen.generics.covariants.arguments.plaingenericinheritance;

import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Base;
import chapters.fifteen.generics.covariants.arguments.covariantreturntypes.Derived;

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();

        DerivedGenericSetter derivedGenericSetter = new DerivedGenericSetter();
        derivedGenericSetter.set(derived);
        // Компилируется: перегрузка, а не переопределение!
        derivedGenericSetter.set(base);
    }
}
