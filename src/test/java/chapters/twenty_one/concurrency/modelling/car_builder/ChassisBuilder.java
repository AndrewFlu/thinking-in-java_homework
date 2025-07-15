package chapters.twenty_one.concurrency.modelling.car_builder;

import java.util.concurrent.TimeUnit;

class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                // Создание кузова
                Car car = new Car(counter++);
                System.out.println("ChassisBuilder created " + car);
                // Помещение в очередь
                carQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}
