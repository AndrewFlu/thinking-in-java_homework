package chapters.twelve.exceptions.lostexception.threelevel;

public class C extends B {
    @Override
    public void mainAction() throws ThirdLevelException {
        System.out.println("C main action");
        throw new ThirdLevelException();
    }
}
