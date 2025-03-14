package chapters.seventeen.containers.weakhashmap;

public class Element {
    private final String ident;

    public Element(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    public boolean equals(Object o) {
        return o instanceof Element &&
                ident.equals(((Element) o).ident);
    }

    public int hashCode() {
        return ident.hashCode();
    }

    protected void finalize()  {
        System.out.println("Finalizig " + getClass().getSimpleName() + " " + ident);
    }
}
