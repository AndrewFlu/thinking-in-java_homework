package chapters.ten.multiimplementation;

public class MultiImplementationTestDrive {
    public static void main(String[] args) {
        C c = new C();
        takesA(c);
        takesB(c.makeB());
    }

    private static void takesB(B b) {

    }

    private static void takesA(A a) {

    }
}
