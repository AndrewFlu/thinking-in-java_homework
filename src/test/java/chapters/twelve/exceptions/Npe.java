package chapters.twelve.exceptions;

import java.util.Arrays;

public class Npe {
    private final String message;

    public Npe(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        Npe npe = null;
        try {
            npe.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }
}
