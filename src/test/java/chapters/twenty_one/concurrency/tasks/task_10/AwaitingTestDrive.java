package chapters.twenty_one.concurrency.tasks.task_10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AwaitingTestDrive {
    public static void main(String[] args) {
        int threadCount = 3;
        if (args.length == 1) {
            threadCount = Integer.parseInt(args[0]);
        }
        System.out.println("Количество потоков для запуска: " + threadCount);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            exec.execute(new AwaitingInfo());
        }
        exec.shutdown();
    }
}
