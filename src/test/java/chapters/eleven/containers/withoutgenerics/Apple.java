package chapters.eleven.containers.withoutgenerics;

public class Apple {
    private static long counter = 0;
    private final long id = counter++;
    public long getId() {
        return id;
    }
}
