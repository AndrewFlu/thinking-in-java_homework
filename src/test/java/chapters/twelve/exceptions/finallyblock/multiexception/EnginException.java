package chapters.twelve.exceptions.finallyblock.multiexception;

public class EnginException extends Exception{
    private static final int CODE = 1548;
    private static final String DESCRIPTION = "Ошибка двигателя. Неисправность лямбда-зонда";

    @Override
    public String getMessage() {
        return "Код ошибки — " + CODE + ": " + DESCRIPTION;
    }
}
