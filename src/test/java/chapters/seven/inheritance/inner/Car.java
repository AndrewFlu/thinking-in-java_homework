package chapters.seven.inheritance.inner;

public class Car extends Vehicle {
    private final String brand;

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public Car(String brand) {
        super("Автомобиль");
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
