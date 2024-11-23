package chapters.fifteen.generics.recurring.notselfbounding;

public class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 item) {
        set(item);

        return get();
    }
}
