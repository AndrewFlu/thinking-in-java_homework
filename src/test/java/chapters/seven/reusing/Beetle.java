package chapters.seven.reusing;

import static net.midview.Print.print;

public class Beetle extends Insect {
    private int k = printInit("Поле Beetle.k инициализировано");

    public Beetle() {
        print(String.format("k = %s", k));
        print(String.format("j = %s", j));
    }

    private static int x2 = printInit("Поле static Beetle.x2 инициализировано");
}
