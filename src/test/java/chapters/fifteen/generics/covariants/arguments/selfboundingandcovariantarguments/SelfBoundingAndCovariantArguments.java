package chapters.fifteen.generics.covariants.arguments.selfboundingandcovariantarguments;

public class SelfBoundingAndCovariantArguments {
    void testA(Setter setter1, Setter setter2, SelfBoundSetter selfBoundSetter) {
        setter1.set(setter2);
        // Ошибка: set(Setter) в SelfBoundSetter<Setter> не может применяться к SelfBoundSetter
//        setter1.set(selfBoundSetter);
    }
}
