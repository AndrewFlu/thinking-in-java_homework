package chapters.nine.abstractexamples.rodent;

public abstract class Rodent {

    protected abstract void run();

    protected abstract void eat();

    public String getName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
