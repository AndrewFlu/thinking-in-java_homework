package chapters.twelve.exceptions.multiexception;

public class HomeTask {

    // f()
    public void testEngine() {
        try {
            testIgnition();
        } catch (IgnitionException e) {
            throw new RuntimeException(e);
        }
    }


    // g()
    public void testIgnition() throws IgnitionException {
        throw new IgnitionException();
    }
}
