package chapters.fifteen.generics.covariants.arguments.selfboundingandcovariantarguments;

public interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}
