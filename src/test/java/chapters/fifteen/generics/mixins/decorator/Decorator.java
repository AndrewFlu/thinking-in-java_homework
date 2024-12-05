package chapters.fifteen.generics.mixins.decorator;

public class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    public String get() {
        return basic.get();
    }

    public void set(String value) {
        basic.set(value);
    }
}
