package chapters.eleven.containers.list.iterator.rodent;

import java.util.Random;

public class RodentGenerator {
    private static final Random random = new Random();

    public static Rodent next() {
        return switch(random.nextInt(3)) {
            default -> new Mouse(new Pool());
            case 1 -> new Hamster(new Pool());
            case 2 -> new Rodent(new Pool());
        };
    }
}
