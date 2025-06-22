package chapters.twenty_one.concurrency.tasks.task_31;

public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }
}
