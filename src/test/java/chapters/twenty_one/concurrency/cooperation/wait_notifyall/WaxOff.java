package chapters.twenty_one.concurrency.cooperation.wait_notifyall;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable{

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.print("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(250);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
