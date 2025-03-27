package chapters.seven.classloading;

import static net.mindview.utils.Print.print;

public class ClassA {
    static String onlyOneInitialization;
    static {
        onlyOneInitialization = "Время инициализации класса = " + System.currentTimeMillis();
        print(onlyOneInitialization);
    }

    String name;

    public ClassA(String name) {
        System.out.println("Работает конструктор ClassA");
        this.name = name;
    }
}
