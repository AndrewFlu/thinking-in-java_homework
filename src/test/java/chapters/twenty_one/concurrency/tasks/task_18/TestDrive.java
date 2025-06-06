package chapters.twenty_one.concurrency.tasks.task_18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        System.out.println("Запускаем задачу на выполнение");
        Future<?> future = exec.submit(new RunnableClass());
        // пусть поработает несколько секунд
        System.out.println("пусть поработает несколько секунд (3)");
        TimeUnit.SECONDS.sleep(3);
        // прерываем задачу
        System.out.println("Прерываем задачу");
        future.cancel(true);
        exec.shutdown();
    }
}
