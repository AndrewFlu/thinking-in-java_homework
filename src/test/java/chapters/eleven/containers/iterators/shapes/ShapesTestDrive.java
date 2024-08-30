package chapters.eleven.containers.iterators.shapes;

public class ShapesTestDrive {
    private static final ShapeGenerator randomShapeGenerator = new ShapeGenerator(10);


    public static ShapeGenerator getRandomShapeGenerator() {
        return randomShapeGenerator;
    }

    public static void main(String[] args) {

        Shape[] randomShapes = new Shape[5];
        for (int i = 0; i < randomShapes.length; i++) {
            randomShapes[i] = randomShapeGenerator.next();
        }

        // полиморфные вызовы draw()
        for (Shape shape : randomShapes) {
            shape.draw();
            shape.printInfo();
            shape.printBaseInfo();
        }
    }
}
