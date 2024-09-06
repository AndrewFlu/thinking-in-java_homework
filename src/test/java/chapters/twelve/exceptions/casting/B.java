package chapters.twelve.exceptions.casting;

public class B extends A {
    @Override
    void printInfo() throws SecondLevelException {
        System.out.println("This is class B");
        throw new SecondLevelException();
    }
}
