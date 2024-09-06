package chapters.twelve.exceptions.casting;

public class ThirdLevelException extends SecondLevelException{
    public ThirdLevelException() {
    }

    @Override
    public String toString() {
        return "Метод toString класса ThirdLevelException";
    }
}
