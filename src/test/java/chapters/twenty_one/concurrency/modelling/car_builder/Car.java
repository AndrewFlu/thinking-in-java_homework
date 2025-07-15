package chapters.twenty_one.concurrency.modelling.car_builder;

class Car {
    private final int id;
    private boolean
            engine = false,
            driveTrain = false,
            wheels = false;

    public Car(int id) {
        this.id = id;
    }

    // Пустой объект Car
    public Car() {
        id = -1;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    @Override
    public synchronized String toString() {
        return "Car " + id +
                " [" + "engine: " + engine +
                ", driveTrain: " + driveTrain +
                ", wheels: " + wheels +
                "]";
    }
}
