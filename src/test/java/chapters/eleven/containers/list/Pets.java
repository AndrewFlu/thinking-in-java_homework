package chapters.eleven.containers.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pets {
    private static final Random random = new Random();

    public static List<Pet> arrayList(int capacity) {
        List<Pet> pets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            pets.add(next());
        }

        return pets;
    }

    private static Pet next() {
        int randomInt = random.nextInt(3);
        return switch (randomInt) {
            case (0) -> new Hamster();
            case (1) -> new Mouse();
            case(2) -> new Cymric();
            default -> throw new IllegalStateException("Unexpected value: " + randomInt);
        };
    }
}
