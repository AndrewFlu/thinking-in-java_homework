package chapters.twelve.exceptions.lostexception;

public class VeryImportantException extends Throwable {
    @Override
    public String toString() {
        return "Очень важное исключение";
    }
}
