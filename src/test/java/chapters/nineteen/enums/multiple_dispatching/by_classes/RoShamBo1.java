package chapters.nineteen.enums.multiple_dispatching.by_classes;

import java.util.Random;

public class RoShamBo1 {
    static final int SIZE = 20;
    private static final Random rand = new Random(47);

    public static Item newItem() {
        return switch (rand.nextInt(3)) {
            default -> new Scissors();
            case 1 -> new Paper();
            case 2 -> new Rock();
        };
    }

    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.complete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
