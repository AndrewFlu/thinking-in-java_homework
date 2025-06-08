package chapters.twenty_one.concurrency.cooperation.wait_notifyall;

public class Car {
    private boolean waxOn = false;

    // воск нанесён
    public synchronized void waxed() {
        waxOn = true; // готово к полировке
        notifyAll();
    }

    // машина отполирована
    public synchronized void buffed() {
        waxOn = false; // готово к нанесению слоя воска
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}

