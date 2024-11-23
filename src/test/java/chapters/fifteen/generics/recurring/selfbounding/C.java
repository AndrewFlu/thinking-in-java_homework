package chapters.fifteen.generics.recurring.selfbounding;

public class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);

        return get();
    }
}
