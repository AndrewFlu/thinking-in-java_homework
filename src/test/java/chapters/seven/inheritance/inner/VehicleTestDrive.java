package chapters.seven.inheritance.inner;

import chapters.seven.inheritance.Bicycle;

public class VehicleTestDrive {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        System.out.println(car.getBrand());

        System.out.println(car.getVehicleName());
        car.startEngine();
        // вызов protected-метода
        car.move();

        Vehicle bicycle = new Bicycle();
        bicycle.stop();
    }
}
