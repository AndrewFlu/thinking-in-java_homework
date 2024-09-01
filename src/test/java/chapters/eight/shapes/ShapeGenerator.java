package chapters.eight.shapes;

import java.util.Random;

public class ShapeGenerator {

    private final Random random = new Random();

    public Shape next() {
        return switch (random.nextInt(4)) {
            case 1 -> new Square(2);
            case 2 -> new Triangle(5);
            case 3 -> new Octagon(7);
            default -> new Circle(5);
        };
    }
}
