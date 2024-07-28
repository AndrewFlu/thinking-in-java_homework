package chapters.seven.reusing;

import static net.midview.Print.print;

public class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println(String.format("i = %s, j = %s", i, j));
        j = 39;
    }

    private static int x1 = printInit("Поле static Insect.x1 инициализировано");

    static int printInit(String s) {
        print(s);

        return 47;
    }
}