package chapters.seven.inheritance.root;

public class Component1 {
    final String label;

    public Component1(String label) {
        this.label = label;
        System.out.println("Вызван конструктор Component1(String label), label = " + label);
    }
}
