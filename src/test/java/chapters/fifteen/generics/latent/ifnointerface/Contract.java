package chapters.fifteen.generics.latent.ifnointerface;

public class Contract {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getName() + " " + id;
    }
}
