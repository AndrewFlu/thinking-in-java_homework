package chapters.twelve.exceptions.lostexception;

public class LostMessage {
    void mainAction() throws VeryImportantException {
        System.out.println("main action is running...generate VeryImportantException");
        throw new VeryImportantException();
    }

    void dispose() throws SecondPriorityException {
        System.out.println("dispose() is running...generate SecondPriorityException");
        throw new SecondPriorityException();
    }
}
