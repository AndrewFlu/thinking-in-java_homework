package chapters.twelve.exceptions.casting;

public class C extends B {
    @Override
    void printInfo() throws ThirdLevelException {
        System.out.println("This is class C");
        throw new ThirdLevelException();
    }
}
