package chapters.twelve.exceptions.lostexception;

public class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "Очень важное исключение";
    }
}
