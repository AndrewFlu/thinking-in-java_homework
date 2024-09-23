package chapters.forteen.typeinfo.shapes;

import java.util.Arrays;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Rhomboid(), new Circle(), new Square(), new Triangle());

        for (Shape shape : shapeList) {
            shape.draw();
            rotate(shape);
        }

        System.out.println();
        Shape rhomboid = new Rhomboid();
        // down-casting
        if (rhomboid instanceof Rhomboid) {
            rhomboid.setActive();
            ((Rhomboid) rhomboid).draw();
        } else {
            throw new RuntimeException("Объект не является типом Rhomboid");
        }
    }

    static void rotate(Shape shape) {
        if (!(shape instanceof Circle)) {
            System.out.println("Фигура " + shape +
                    " повёрнута");
        }
    }
}
