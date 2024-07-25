package chapters.six.access;

public class ProtectedData {
    protected String id;
    protected int count;

    protected ProtectedData() {
        System.out.println("Защищенный конструктор");
    }

    protected void printData() {
        System.out.println("id — " + id);
        System.out.println("count — " + count);
    }
}

class UseProtectedData {
    public void use() {
        ProtectedData data = new ProtectedData();
        data.printData();
    }

    public static void main(String[] args) {
        new UseProtectedData().use();
    }
}