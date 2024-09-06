package chapters.twelve.exceptions.casting;

public class FirstLevelException extends Exception{
    public FirstLevelException() {
    }

    @Override
    public String toString() {
        return "Метод toString класса FirstLevelException";
    }

    @Override
    public String getMessage() {
        return "Message: " + toString();
    }
}
