package chapters.twelve.exceptions.multiexception;

public class HomeTask {

    public void testEngine() throws EnginException {
        try {
            testIgnition();
        } catch (IgnitionException e) {
            throw new EnginException();
        }
    }

    public void testIgnition() throws IgnitionException {
        throw new IgnitionException();
    }
}
