package chapters.twelve.exceptions.lostexception.threelevel;

public class A {

    public void mainAction() throws FirstLevelException {
        System.out.println("A main action");
        throw new FirstLevelException();
    }
}
