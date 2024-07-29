package chapters.eight.cycles;

import java.util.Random;

public class CycleGenerator {
    private final Random random = new Random();

    public Cycle next() {
        return switch (random.nextInt(3)) {
            default -> new Unicycle();
            case 1 -> new Bicycle();
            case 2 -> new Tricycle();
        };
    }
}
