package chapters.twelve.exceptions.custom;

public class CustomClass {
    public static final int MAX_LIMIT = 4;
    private static int counter = 1;
    private final int id;

    public CustomClass() {
        id = counter++;
    }

    public int getId() throws CustomException {
        if (id > MAX_LIMIT) throw new CustomException("Максимально возможное количество объектов: " + MAX_LIMIT);
        return id;
    }
}
