package chapters.seven.inheritance.initialisation;

public class Base {
    String baseString;
    {
        System.out.println("Начало инициализации полей класса Base");
        baseString = "Base string";
        System.out.println("Base.baseString = " + baseString);
        System.out.println("Конец инициализации полей класса Base");
    }
    public Base() {
        baseString = "Updated in constructor string";
        System.out.println("Конструктор базового класса");
    }
}
