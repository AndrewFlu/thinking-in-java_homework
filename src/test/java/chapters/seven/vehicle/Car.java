package chapters.seven.vehicle;

public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheels = new Wheel[4];
    public Door
            leftDoor = new Door(),
            rightDoor = new Door();

    public Car() {
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();

        car.wheels[1].inflate(250);
        car.leftDoor.open();
        car.leftDoor.close();
        car.engine.start();
        car.leftDoor.window.rollDown();
    }
}
