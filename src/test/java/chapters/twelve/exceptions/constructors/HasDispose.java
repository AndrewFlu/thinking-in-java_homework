package chapters.twelve.exceptions.constructors;

public class HasDispose {
    private static int counter = 0;
    private final int id = counter++;

    public void dispose() {
        System.out.println("Завершающие действия для " + this);
    }

    @Override
    public String toString() {
        return "HasDispose with id = " + id;
    }
}
