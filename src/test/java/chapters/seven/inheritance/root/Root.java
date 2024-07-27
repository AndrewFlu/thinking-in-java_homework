package chapters.seven.inheritance.root;

public class Root {
    private final int id;
    Component1 component1;
    Component2 component2;
    Component3 component3;

    {
        component1 = new Component1("Root 1");
        component2 = new Component2("Root 2");
        component3 = new Component3("Root 3");
    }

    public Root(int id) {
        this.id = id;
        System.out.println("Вызван конструктор Root(int id), id = " + id);
    }

    void dispose() {
        System.out.println("Вырываем корень");
    }
}
