package chapters.twelve.exceptions.autoinfo;

public class Auto1 extends Exception {
    private final int id = 45;

    public String getMessage() {
        return "Error code: " + id;
    }
}
