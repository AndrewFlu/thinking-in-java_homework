package chapters.seven.inheritance.root;

public class Component2 {
    final String label;

    public Component2(String label) {
        this.label = label;
        System.out.println("Вызван конструктор Component2(String label), label = " + label);
    }
}
