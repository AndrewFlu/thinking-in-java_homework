package chapters.twenty_one.concurrency.tasks.task_42;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();

        List<Future<?>> commandList = new CopyOnWriteArrayList<>();
        commandList.add(car.waxOff());
        commandList.add(car.waxOn());

        while (commandList.size() > 0) {
            for (Future<?> f : commandList) {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
                commandList.remove(f);
            }
        }
        TimeUnit.SECONDS.sleep(2);
        car.shutdown(); // прервать все задачи
    }
}
