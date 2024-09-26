package chapters.forteen.typeinfo.initiable;

public class Initable {

    // test variables
    public static final String COMPILE_TIME_STRING = "I am a constant";
    public static String compileTimeString = "I am a not final constant";

    public static final int COMPILE_TIME_INT = 10;
    public static int compileTimeInt = 11;

    public static final int STATIC_FINAL_NOT_COMPILE_TIME_INT = InitializationTestDrive.rand.nextInt(1000);
    public static int staticFinalNotCompileTimeInt = InitializationTestDrive.rand.nextInt(1000);

    static {
        System.out.println("Инициализация класса Initable");
    }
}
