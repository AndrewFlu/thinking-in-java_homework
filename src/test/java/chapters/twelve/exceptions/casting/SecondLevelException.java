package chapters.twelve.exceptions.casting;


public class SecondLevelException extends FirstLevelException {
    public SecondLevelException() {
    }

    @Override
    public String toString() {
        return "Метод toString класса SecondLevelException";
    }
}
