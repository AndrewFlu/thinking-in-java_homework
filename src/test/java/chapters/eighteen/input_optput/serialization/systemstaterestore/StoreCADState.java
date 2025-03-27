package chapters.eighteen.input_optput.serialization.systemstaterestore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StoreCADState {
    public static void main(String[] args) throws IOException {
        List<Shape> shapes = new ArrayList<>();
        // создаём несколько фигур:
        for (int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        // устанавливаем все статические цвета в зелёный:
        for (int i = 0; i < 10; i++)
            shapes.get(i).setColor(Shape.GREEN);
        // сохраняем вектор состояния
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        // записываем статические поля
        Circle.serializeStaticState(out);
        Line.serializeStaticState(out);
        Square.serializeStaticState(out);
        // записываем объекты
        out.writeObject(shapes);
        // отображение набора фигур:
        System.out.println(shapes);
    }
}
