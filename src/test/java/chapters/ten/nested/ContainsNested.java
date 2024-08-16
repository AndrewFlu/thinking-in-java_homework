package chapters.ten.nested;

public class ContainsNested {
    private int id = 111;
    public ContainsNested() {
        System.out.println("Создание экземапляра внешнего класса");
    }

    public static class Nested {
        public Nested() {
            System.out.println("Создание экземпляра вложенного класса (static)");
        }
    }
}
