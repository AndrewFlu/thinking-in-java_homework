package chapters.ten.interfaces.engins;

public class DieselEngine implements IEngine {
    @Override
    public void start() {
        System.out.println("Дизель запустился!");
    }

    @Override
    public void stop() {
        System.out.println("Дизель заглушён!");
    }
}
