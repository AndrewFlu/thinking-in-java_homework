package chapters.eight.shapes;

import java.util.Random;

public class ShapeGenerator {

    private final Random random = new Random();

    public Shape next() {
        return switch (random.nextInt(3)) {
            case 1 -> new Square();
            case 2 -> new Triangle();
            default -> new Circle();
        };
    }
}
