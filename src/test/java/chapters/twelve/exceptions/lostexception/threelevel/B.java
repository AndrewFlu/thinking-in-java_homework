package chapters.twelve.exceptions.lostexception.threelevel;

public class B extends A {
    @Override
    public void mainAction() throws SecondLevelException {
        System.out.println("B main action");
        throw new SecondLevelException();
    }
}
