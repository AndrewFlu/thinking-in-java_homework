package chapters.twelve.exceptions.multiexception;

public class CarTestDrive {
    public static void main(String[] args) {
        Car audi = new Car("Audi A3", 3, false, true);
        Car bmw = new Car("BMW 1-series E81 120d", 7, false, false);
        Car bmwX6 = new Car("BMW X6 E71", 5, true, true);

        Car[] cars = {audi, bmw, bmwX6};

        for (Car car : cars) {
            car.checkCar();
        }

    }
}
