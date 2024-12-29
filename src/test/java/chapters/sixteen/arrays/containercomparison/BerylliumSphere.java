package chapters.sixteen.arrays.containercomparison;

public class BerylliumSphere implements Comparable<BerylliumSphere> {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }

    @Override
    public int compareTo(BerylliumSphere o) {
        return id < o.id ? -1 : (id == o.id ? 0 : 1);
    }
}
