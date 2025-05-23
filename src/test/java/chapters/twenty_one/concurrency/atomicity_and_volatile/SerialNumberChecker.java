package chapters.twenty_one.concurrency.atomicity_and_volatile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
// {Args: 4}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static final CircularSet serials = new CircularSet(1000);
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++)
            executor.execute(new SerialChecker());
        // Остановка через n секунд при наличии аргумента
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }

    }

    static class CircularSet {
        private final int[] array;
        private final int len;
        private int index = 0;

        public CircularSet(int size) {
            array = new int[size];
            len = size;
            // Инициализируем значением, которое не производится классом SerialNumberGenerator
            for (int i = 0; i < size; i++) {
                array[i] = -1;
            }
        }

        public synchronized void add(int i) {
            array[index] = i;
            // "Перенос" индекса с перезаписью старых элементов:
            index = ++index % len;
        }

        public synchronized boolean contains(int val) {
            for (int i = 0; i < len; i++)
                if (array[i] == val)
                    return true;
            return false;
        }

    }
}
