package chapters.twenty_one.concurrency.modelling.car_builder;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Assembler implements Runnable {

    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4); // todo: почему 4?
    private RobotPool robotPool;

    public Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }

    public Car getCar() {
        return car;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Блокируется, пока кузов не будет доступен:
                car = chassisQueue.take();

                // Привелечение роботов для выполнения работы:
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);

                barrier.await(); // пока роботы не закончат работу

                // машина помещается в очередь finishingQueue для дальнейшей работы:
                finishingQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            // исключение, о котором нужно знать
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }
}
