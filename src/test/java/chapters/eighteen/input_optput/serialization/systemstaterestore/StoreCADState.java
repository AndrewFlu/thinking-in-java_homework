package chapters.eighteen.input_optput.serialization.systemstaterestore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StoreCADState {
    public static void main(String[] args) throws IOException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        // Добавляем ссылки на объекты Class:
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        // создаём несколько фигур:
        for (int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        // устанавливаем все статические цвета в зелёный:
        for (int i = 0; i < 10; i++)
            shapes.get(i).setColor(Shape.GREEN);
        // сохраняем вектор состояния
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        // отображение набора фигур:
        System.out.println(shapes);
    }
}
