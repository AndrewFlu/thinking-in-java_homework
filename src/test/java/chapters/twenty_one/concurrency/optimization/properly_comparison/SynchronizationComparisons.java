package chapters.twenty_one.concurrency.optimization.properly_comparison;

public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synch = new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();

    static void test() {
        System.out.println("=============================");
        System.out.printf("%-12s : %13d\n", "Cycles", AbstractAccumulator.cycles);
        baseLine.timedTest();
        synch.timedTest();
        lock.timedTest();
        atomic.timedTest();

        AbstractAccumulator.report(synch, baseLine);
        AbstractAccumulator.report(lock, baseLine);
        AbstractAccumulator.report(atomic, baseLine);

        AbstractAccumulator.report(synch, lock);
        AbstractAccumulator.report(synch, atomic);
        AbstractAccumulator.report(lock, atomic);
    }

    public static void main(String[] args) {
        int iterations = 5;
        if (args.length > 0)
            iterations = Integer.parseInt(args[0]);
        // При первом проходе заполняется пул потоков:
        System.out.println("Warmup");
        baseLine.timedTest();
        // Теперь исходный тест не включает затраты на первый запуск потоков

        // Создание множественных элементов данных:
        for (int i = 0; i < iterations; i++) {
            test();
            AbstractAccumulator.cycles *= 2;
        }
        AbstractAccumulator.exec.shutdown();
    }
}
