package chapters.seven.inheritance.initialisation;

public class Base {
    static Integer baseStaticInteger;
    static {
        baseStaticInteger = 10;
        System.out.println("Инициализация статических данных класса Base");
    }

    String baseString;
    {
        System.out.println("");
        System.out.println("Начало инициализации полей класса Base");
        baseString = "Base string";
        System.out.println("Base.baseString = " + baseString);
        System.out.println("Конец инициализации полей класса Base");
    }
    public Base() {
        baseString = "Updated in constructor string";
        System.out.println("Конструктор базового класса");
        System.out.println("");
    }
}
