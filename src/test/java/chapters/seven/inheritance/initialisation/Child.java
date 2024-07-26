package chapters.seven.inheritance.initialisation;

public class Child extends Base{
    String childString = "Child string";

    public Child() {
        System.out.println("Конструктор ребёнка");
    }
}
