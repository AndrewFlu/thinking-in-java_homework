package chapters.twenty_one.concurrency.tasks.task_41;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ActiveObjectDemo {
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);

    // Вставка случайной задержи
    // для моделирования времени вычисления
    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) { // todo: почему здесь final?
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(2_000);
                return x + y;
            }
        });
    }

    public void justPrint(String s) {
        exec.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Just printing: " + s);
            }
        });
    }

    public void shutdown() {
        exec.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();

        // Предотвращает ConcurrentModificationException:
        List<Future<?>> results = new CopyOnWriteArrayList<>();
        for (float f = 0.0f; f < 1.0f; f += 0.2f) {
            results.add(d1.calculateFloat(f, f));
        }
        for (int i = 0; i < 4; i++) {
            results.add(d1.calculateInt(i, i));
        }

        for (int i = 0; i < 5; i++) {
            d1.justPrint(String.valueOf(i));
        }
        System.out.println("All asynch calls made");
        while (results.size() > 0) {
            for (Future<?> f : results)
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    results.remove(f);
                }
        }
        d1.shutdown();
    }
}
