package chapters.seven.inheritance.root;

public class Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    {
        component1 = new Component1();
        component2 = new Component2();
        component3 = new Component3();
    }

    public Root() {
        System.out.println("Вызван конструктор Root");
    }
}
