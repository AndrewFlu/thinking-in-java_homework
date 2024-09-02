package chapters.twelve.exceptions.lostexception.threelevel;

public class SecondLevelException extends FirstLevelException {
    @Override
    public String toString() {
        return "SecondLevelException";
    }
}
