package chapters.eighteen.input_optput.serialization.systemstaterestore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        // Читаем объекты в том порядке, в котором они были записаны
        Circle.deserializeStaticState(in);
        Line.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
