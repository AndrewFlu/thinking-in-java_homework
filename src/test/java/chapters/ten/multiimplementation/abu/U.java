package chapters.ten.multiimplementation.abu;

public class U {
    private static int count = 0;
    private final int id;

    public U() {
        id = count++;
    }

    void first() {
        System.out.println("U.first() with object id = " + id);
    }

    void second() {
        System.out.println("U.second() with object id = " + id);
    }

    void third() {
        System.out.println("U.third() with object id = " + id);
    }
}
