package chapters.twelve.exceptions.multiexception;

public class WasherException extends Exception {
    private static final int CODE = 7711;
    private static final String DESCRIPTION = "Недостаточный уровень жидкости стеклоочистителя";

    @Override
    public String getMessage() {
        return "Код ошибки — " + CODE + ": " + DESCRIPTION;
    }
}
