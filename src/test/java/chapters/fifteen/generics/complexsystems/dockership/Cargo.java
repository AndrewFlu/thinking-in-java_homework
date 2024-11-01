package chapters.fifteen.generics.complexsystems.dockership;

import utils.Generator;

import java.util.Random;

public class Cargo {
    private final int id;
    private String description;
    private double weight;

    public Cargo(int id, String description, double weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public String toString() {
        return String.format("Товар на перевозку, id: %d, [%s], вес: %s кг", id, description, weight);
    }

    public static Generator<Cargo> generator = new Generator<Cargo>() {
        private final Random random = new Random();

        @Override
        public Cargo next() {
            return new Cargo(random.nextInt(100), "Товар сгенерирован", Math.round(random.nextDouble() * 1000));
        }
    };
}
