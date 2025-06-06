package chapters.twenty_one.concurrency.tasks.task_20;

public class LiftOff20 implements Runnable {

    protected int countDown = 100; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff20() {
    }

    public LiftOff20(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0)  {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("LiftOff interrupted! " + status());
                break;
            }
            System.out.println(status());
            Thread.yield(); // yield — уступать (сообщить планировщику потоков, что основная задача в потоке выполнена и можно переключать выполнение на другой поток)
        }
    }
}
