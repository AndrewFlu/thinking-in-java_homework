package chapters.fifteen.generics.recurring.selfbounding;

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();

        C c = new C();
        c.setAndGet(new C());
    }
}
