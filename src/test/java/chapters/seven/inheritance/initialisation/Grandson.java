package chapters.seven.inheritance.initialisation;

public class Grandson extends Child {
    static Integer grandsonStaticInteger;
    static {
        grandsonStaticInteger = 11;
        System.out.println("Инициализация статических данных класса Grandson");
    }

    private String grandsonString;
    {
        System.out.println("");
        System.out.println("Начало инициализации полей класса Grandson");
        grandsonString = "Grandson string";
        System.out.println("Grandson.baseString = " + grandsonString);
        System.out.println("Конец инициализации полей класса Grandson");
    }
    public Grandson() {
        System.out.println("Конструктор внука");
        System.out.println("");
    }
}
