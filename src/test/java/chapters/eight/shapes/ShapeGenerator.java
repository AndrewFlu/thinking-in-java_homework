package chapters.eight.shapes;

import java.util.Random;

public class ShapeGenerator {

    private final Random random = new Random();

    public Shape next() {
        return switch (random.nextInt(4)) {
            case 1 -> new Square();
            case 2 -> new Triangle();
            case 3 -> new Octagon();
            default -> new Circle();
        };
    }
}
