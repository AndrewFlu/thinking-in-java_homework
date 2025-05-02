package chapters.twenty_one.concurrency.tasks.task_8;

public class LiftOff_8 implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff_8() {
    }

    public LiftOff_8(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }

    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                Thread.yield(); // yield — уступать (сообщить планировщику потоков, что основная задача в потоке выполнена и можно переключать выполнение на другой поток)
            }
        } finally {
            System.out.println("Finally block for thread #" + id);
        }
    }
}
