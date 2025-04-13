package chapters.nineteen.enums.multiple_dispatching.by_enums;

import net.mindview.utils.Enums;

public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " versus " + b + ": " + a.complete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }
}
