package chapters.nine.abstractexamples.rodent;

import java.util.Random;

public class RodentGenerator {
    private static final Random random = new Random();

    public static Rodent next() {
        int nextInt = random.nextInt(3);
        if (nextInt < 2) {
            return new Mouse();
        } else {
            return new Hamster();
        }
    }
}
