package chapters.fifteen.generics.latent.applymethod;

import chapters.forteen.typeinfo.pets.Cat;
import chapters.forteen.typeinfo.pets.Pet;
import chapters.forteen.typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapes = new ArrayList<Shape>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }

        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);

        List<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }

        Apply.apply(squares, Square.class.getMethod("rotate"));
        Apply.apply(squares, Square.class.getMethod("resize", int.class), 7);

        Apply.apply(new FilledList<>(Shape.class, 4), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<>(Square.class, 3), Square.class.getMethod("resize", int.class), 5);

        SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
        for (int i = 0; i < 7; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
        Apply.apply(shapeQ, Square.class.getMethod("resize", int.class), 3);

        Pet[] array = Pets.createArray(7);
        Apply.apply(Arrays.asList(array), Pet.class.getMethod("speak"));
    }
}
