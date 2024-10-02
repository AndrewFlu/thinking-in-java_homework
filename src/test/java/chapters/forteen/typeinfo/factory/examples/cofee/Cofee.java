package chapters.forteen.typeinfo.factory.examples.cofee;

public class Cofee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
