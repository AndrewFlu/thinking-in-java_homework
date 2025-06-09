package chapters.twenty_one.concurrency.tasks.task_21;

public class Washer implements Runnable {

    private boolean isClean = false;

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
                System.out.println("Washing is running");
            } catch (InterruptedException e) {
                System.out.println("Washing interrupted");
            } finally {
                System.out.println("washer has stopped working");
            }
        }
    }

    public synchronized void wash() {
        System.out.println("Чистка начата");
        isClean = true;
        System.out.println("Чистка окончена");
    }
}
