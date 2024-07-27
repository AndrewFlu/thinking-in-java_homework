package chapters.seven.inheritance.root;

public class Component3 {
    final String label;

    public Component3(String label) {
        this.label = label;
        System.out.println("Вызван конструктор Component3(String label), label = " + label);
    }
}
