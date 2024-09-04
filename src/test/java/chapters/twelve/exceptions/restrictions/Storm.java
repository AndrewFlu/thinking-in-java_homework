package chapters.twelve.exceptions.restrictions;

public interface Storm {
    void event() throws RainedOut;
    void rainedHard() throws RainedOut;
}
