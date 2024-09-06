package chapters.twelve.exceptions.casting;

public class ExceptionCastingTestDrive {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A ca = new C();
        try {
//            a.printInfo();
//            b.printInfo();

//            c.printInfo();
            ca.printInfo();
        } catch (ThirdLevelException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace(System.out);
        } catch (SecondLevelException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        } catch (FirstLevelException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
