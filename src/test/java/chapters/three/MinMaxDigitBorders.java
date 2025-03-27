package chapters.three;

import static java.lang.String.format;
import static net.mindview.utils.Print.print;

public class MinMaxDigitBorders {
    private static final Double MAX_DOUBLE = Double.MAX_VALUE;
    private static final Double MIN_DOUBLE = Double.MIN_VALUE;
    private static final Float MAX_FLOAT = Float.MAX_VALUE;
    private static final Float MIN_FLOAT = Float.MIN_VALUE;

    public static void main(String[] args) {
        print(format("Максимальное значение Double = %s", MAX_DOUBLE));
        print(format("Минимальное значение Double = %s", MIN_DOUBLE));
        print(format("Максимальное значение Float = %s", MAX_FLOAT));
        print(format("Минимальное значение Float = %s", MIN_FLOAT));
    }
}
