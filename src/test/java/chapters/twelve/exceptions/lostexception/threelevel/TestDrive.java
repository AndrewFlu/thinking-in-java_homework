package chapters.twelve.exceptions.lostexception.threelevel;

public class TestDrive {
    public static void main(String[] args) {
        A objectC = new C();
        try {
            objectC.mainAction();
        } catch (FirstLevelException ex) {
            System.out.println(ex);
        }
    }
}
