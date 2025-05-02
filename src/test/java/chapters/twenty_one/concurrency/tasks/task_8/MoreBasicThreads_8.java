package chapters.twenty_one.concurrency.tasks.task_8;

import java.util.concurrent.TimeUnit;

public class MoreBasicThreads_8 {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Starting daemons processes");
            for (int i = 0; i < 5; i++) {
                Thread thread = new Thread(new LiftOff_8());
                thread.setDaemon(true);
                thread.start();
            }
            System.out.println("Waiting for liftOff()");
            TimeUnit.MILLISECONDS.sleep(8); // ожидание для выполнения созданных потоков-демонов
        } finally {
            System.out.println("All daemon processes is stopped");
        }
    }
}
