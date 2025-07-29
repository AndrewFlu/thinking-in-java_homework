package chapters.twenty_one.concurrency.tasks.task_42;

import java.util.concurrent.*;

public class Car {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    private boolean waxOn = false;

    public Future<Boolean> waxOff() {
        return executor.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                try {
                    while (!Thread.interrupted()) {
                        waxOn = false;
                        System.out.print("Wax Off! ");
                        TimeUnit.MILLISECONDS.sleep(250);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Exiting via interrupt");
                }
                System.out.println("Ending Wax Off task");

                return waxOn;
            }
        });
    }

    public Future<Boolean> waxOn() {
        return executor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                try {
                    while (!Thread.interrupted()) {
                        System.out.print("Wax On! ");
                        TimeUnit.MILLISECONDS.sleep(250);
                        waxOn = true;
                    }
                } catch (InterruptedException e) {
                    System.out.println("Exiting via interrupt");
                }

                System.out.println("Ending Wax On task");

                return waxOn;
            }
        });
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}

