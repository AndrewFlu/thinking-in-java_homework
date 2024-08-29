package chapters.eleven.containers.collectionanditerator.pets;

import java.util.Random;

public class Pets {
    private static final Random random = new Random();

    public static Pet[] createArray(int capacity) {
        Pet[] array = new Pet[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = getRandomPet();
        }

        return array;
    }

    private static Pet getRandomPet() {
        return switch (random.nextInt(3)) {
            case 1 -> new Cat("Санса");
            case 2 -> new Cat("Джем");
            default -> new Dog("Пончик");
        };
    }
}
