package chapters.five.overloading.chapters.five.sto;

public class Car {
    private String brand;
    private boolean isHealthy;

    public Car(String brand) {
        this.brand = brand;
        this.isHealthy = true;
    }

    public String getBrand() {
        return brand;
    }

    public boolean getHealth() {
        return isHealthy;
    }

    public void setHealth(boolean isOk) {
        isHealthy = isOk;
    }
}
