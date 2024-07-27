package chapters.seven.inheritance.inner;

public class Vehicle {
    private String transportName;

    public Vehicle(String transportName) {
        this.transportName = transportName;
    }

    protected void move() {
        System.out.println("Транспортное средство движется");
    }

    protected void stop() {
        System.out.println("Транспортное средство остановлено");
    }

    public String getVehicleName() {
        return transportName;
    }


}
