package chapters.seven.reusing;

import static net.mindview.utils.Print.print;

public class MayBeetle extends Beetle {
    private static int x3 = printInit("Поле static MayBeetle.x3 инициализировано");
    private int m = printInit("Поле MatBeetle.m инициализировано");

    public MayBeetle() {
        print(String.format("m = %s", m));
        print(String.format("j = %s", j));
    }

}
