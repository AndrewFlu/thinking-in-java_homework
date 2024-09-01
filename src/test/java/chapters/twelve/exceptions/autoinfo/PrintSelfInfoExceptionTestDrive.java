package chapters.twelve.exceptions.autoinfo;

public class PrintSelfInfoExceptionTestDrive {
    public static void main(String[] args) {
        try {
            throw new Auto1();
        } catch (Auto1 auto1) {
            auto1.printStackTrace(System.out);
        }

        try {
            throw new Auto2();
        } catch (Auto2 auto2) {
            auto2.printStackTrace(System.out);
        }
    }
}
