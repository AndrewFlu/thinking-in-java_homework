package chapters.seven.vehicle;

public class Door {
    public Window window = new Window();

    public void open() {
        System.out.println("Дверь открыта");
    }

    public void close() {
        System.out.println("Дверь закрыта");
    }
}
