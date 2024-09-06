package chapters.twelve.exceptions.casting;

public class A {
    void printInfo() throws FirstLevelException {
        System.out.println("This is class A");
        throw new FirstLevelException();
    }
}
