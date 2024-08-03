package chapters.nine.interfaceexamples.rodent;

public interface Rodent {

    default String getName() {
        return getClass().getSimpleName();
    }

    void run();

    void eat();

}
