package chapters.twenty_one.concurrency.tasks.task_23;

public class Car {
    private boolean waxOn = false;

    // воск нанесён
    public synchronized void waxed() {
        waxOn = true; // готово к полировке
        notify();
    }

    // машина отполирована
    public synchronized void buffed() {
        waxOn = false; // готово к нанесению слоя воска
        notify();
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

