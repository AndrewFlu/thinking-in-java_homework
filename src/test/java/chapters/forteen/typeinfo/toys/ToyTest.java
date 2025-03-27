package chapters.forteen.typeinfo.toys;

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
            c = Class.forName("chapters.forteen.typeinfo.toys.FancyToy");
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
        Object obj = null;
        try {
            // Необходим конструктор по умолчанию
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Не удалось создать экземпляр");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Отказано в доступе");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
