package chapters.twenty_one.concurrency.access_to_resources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int ident) {
        this.id = ident;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int value = generator.next();
            if (value % 2 != 0) {
                System.out.println(value + " not even!");
                generator.cancel(); // Отменяет все объекты EvenChecker
            }
        }
    }

    // Тестирование любого типа IntGenerator
    public static void test(IntGenerator gen, int count) {
        System.out.println("Press Control-C to exit");

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            executor.execute(new EvenChecker(gen, i));
        executor.shutdown();
    }

    // Значение по умолчанию для count:
    public static void test(IntGenerator gen) {
        test(gen, 10);
    }
}
