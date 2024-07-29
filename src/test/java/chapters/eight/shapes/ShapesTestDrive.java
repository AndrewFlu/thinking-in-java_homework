package chapters.eight.shapes;

public class ShapesTestDrive {
    private static final ShapeGenerator randomShapeGenerator = new ShapeGenerator();

    public static void main(String[] args) {
        Shape[] randomShapes = new Shape[10];
        for (int i = 0; i < randomShapes.length; i++) {
            randomShapes[i] = randomShapeGenerator.next();
        }

        // полиморфные вызовы draw()
        for (Shape shape : randomShapes) {
            shape.draw();
        }
    }
}
