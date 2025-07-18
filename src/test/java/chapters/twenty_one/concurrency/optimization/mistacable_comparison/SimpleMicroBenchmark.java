package chapters.twenty_one.concurrency.optimization.mistacable_comparison;

import org.apache.xerces.util.SynchronizedSymbolTable;

// Опасность микрохронометража. Тест выполняется БЕЗ конкуренции за ресурсы (мьютексы), в одном потоке.
// К тому же Компилятор модет оптимизировать данные вычисления, т.к. колическтво итерация заранее известно,

public class SimpleMicroBenchmark {

    static long test(AbstractIncrementable incrementable) {
        long start = System.nanoTime();
        for (int i = 0; i < 10_000_000L; i++)
            incrementable.increment();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());
        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("lock: %1$10d\n", lockTime);
        System.out.printf("Lock/synchronized = %1$.3f", (double)lockTime / (double)synchTime);
    }
}
