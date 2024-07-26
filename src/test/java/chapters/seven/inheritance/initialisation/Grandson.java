package chapters.seven.inheritance.initialisation;

public class Grandson extends Child {
    private String grandsonString;
    {
        System.out.println("Начало инициализации полей класса Grandson");
        grandsonString = "Grandson string";
        System.out.println("Grandson.baseString = " + grandsonString);
        System.out.println("Конец инициализации полей класса Grandson");
    }
    public Grandson() {
        System.out.println("Конструктор внука");
    }
}
