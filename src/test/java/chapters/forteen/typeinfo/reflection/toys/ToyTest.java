package chapters.forteen.typeinfo.reflection.toys;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static net.mindview.utils.Print.print;

public class ToyTest {
    static void printInfo(Class cc) {
        print("Имя класса: " + cc.getName() + " является интерфейсом? [" + cc.isInterface() + "]");
        print("Простое имя: " + cc.getSimpleName());
        print("Каноническое имя: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("chapters.forteen.typeinfo.reflection.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Не удаётся найти FancyToy");
            System.exit(1);
        }
        printInfo(c);

        // интрерфейсы
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        // базовый класс
        Class up = c.getSuperclass();
        Object toyObj = null;
        try {
            final Constructor<?> constructor = up.getDeclaredConstructor(int.class);
            toyObj = constructor.newInstance(5);
        } catch (InstantiationException e) {
            print("Не удалось создать экземпляр");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Отказано в доступе");
            System.exit(1);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        printInfo(toyObj.getClass());
    }
}
