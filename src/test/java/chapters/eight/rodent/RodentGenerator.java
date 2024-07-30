package chapters.eight.rodent;

import java.util.Random;

public class RodentGenerator {
    private static final Random random = new Random();

    public static Rodent next() {
        return switch(random.nextInt(3)) {
            default -> new Mouse();
            case 1 -> new Hamster();
            case 2 -> new Rodent();
        };
    }
}
