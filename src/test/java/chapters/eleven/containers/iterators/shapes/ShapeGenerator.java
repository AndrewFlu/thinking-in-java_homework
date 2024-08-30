package chapters.eleven.containers.iterators.shapes;

import java.util.Iterator;
import java.util.Random;

public class ShapeGenerator implements Iterable<Shape>{
    private int index = 0;
    private Shape[] shapes;

    public ShapeGenerator(int count) {
        shapes = new Shape[count];
        fillArray(count);
    }

    private void fillArray(int capacity) {
        for (int i = 0; i < capacity; i++) {
            shapes[i] = next();
        }
    }

    private final Random random = new Random();

    public Shape next() {
        return switch (random.nextInt(4)) {
            case 1 -> new Square();
            case 2 -> new Triangle();
            case 3 -> new Octagon();
            default -> new Circle();
        };
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            @Override
            public boolean hasNext() {
                return index < shapes.length;
            }

            @Override
            public Shape next() {
                return shapes[index++];
            }
        };
    }
}
