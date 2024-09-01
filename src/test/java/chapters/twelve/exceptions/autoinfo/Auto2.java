package chapters.twelve.exceptions.autoinfo;

public class Auto2 extends Exception{
    private final int code = 3402;

    public String getMessage() {
    return "Error code " + code;
    }
}


