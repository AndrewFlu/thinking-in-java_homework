package chapters.forteen.typeinfo.shapes;

import java.util.Arrays;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Rhomboid(), new Circle(), new Square(), new Triangle());

        for (Shape shape : shapeList) {
            shape.draw();
        }

        System.out.println();
        Shape rhomboid = new Rhomboid();
        // down-casting
        ((Rhomboid)rhomboid).draw();
        // casting to Circle
        ((Circle)rhomboid).draw();
    }
}
