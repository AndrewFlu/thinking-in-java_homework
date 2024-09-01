package chapters.twelve.exceptions.finallyblock.multiexception;

public class IgnitionException extends Exception {
    private static final int CODE = 1142;
    private static final String DESCRIPTION = "Ошибка зажигания. Неисправность катушки зажигания";

    @Override
    public String getMessage() {
        return "Код ошибки — " + CODE + ": " + DESCRIPTION;
    }
}
