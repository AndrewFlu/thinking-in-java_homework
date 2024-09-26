package chapters.forteen.typeinfo.initiable;

import java.util.Random;

public class InitializationTestDrive {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initableClass = Initable.class; // класс не загружается
        System.out.println("После создания ссылки на класс Initable");

        // класс не загружается
        System.out.println(Initable.COMPILE_TIME_INT);
        System.out.println(Initable.COMPILE_TIME_STRING);

        System.out.println();

        // выполняется загрузка класса
        System.out.println("Будет выполнена загрузка класса");
        System.out.println(Initable.compileTimeInt);
        System.out.println(Initable.compileTimeString);
        System.out.println(Initable.STATIC_FINAL_NOT_COMPILE_TIME_INT);
        System.out.println(Initable.staticFinalNotCompileTimeInt);

        // запускает процесс инициализации (загрузка класса, компоновка, инициализация)
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("chapters.forteen.typeinfo.initiable.Initable3");
        System.out.println("После создания ссылки на класс Initable3");
        System.out.println(Initable3.staticNonFinal);
    }
}
