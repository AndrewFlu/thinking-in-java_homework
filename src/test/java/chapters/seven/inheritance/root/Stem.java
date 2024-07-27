package chapters.seven.inheritance.root;

public class Stem extends Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    {
        component1 = new Component1("Stem 1");
        component2 = new Component2("Stem 2");
        component3 = new Component3("Stem 3");
    }

    public Stem(int stemId) {
        super(stemId);
        System.out.println("Вызван конструктор Stem");
    }

    void dispose() {
        System.out.println("Срубаем стебель");
        super.dispose();
    }
}
