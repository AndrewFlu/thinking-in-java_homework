package chapters.twelve.exceptions.constructors;

public class FailingConstructorTestDrive {
    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor(1);
            try {
                fc.printInfo();
            } finally {
                System.out.println("clean up");
                fc.dispose();
            }
        } catch (ConstructorException e) {
            System.out.println("Null reference in constructing object");
        }
    }
}
