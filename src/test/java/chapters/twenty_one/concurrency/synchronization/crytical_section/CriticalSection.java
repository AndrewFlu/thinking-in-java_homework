package chapters.twenty_one.concurrency.synchronization.crytical_section;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    // Тестирование двух разных подхходов
    public static void testApproaches(PairManager pm1, PairManager pm2) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator
                pairManipulator1 = new PairManipulator(pm1),
                pairManipulator2 = new PairManipulator(pm2);
        PairChecker
                pairChecker1 = new PairChecker(pm1),
                pairChecker2 = new PairChecker(pm2);

        executorService.execute(pairManipulator1);
        executorService.execute(pairManipulator2);

        executorService.execute(pairChecker1);
        executorService.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pairManipulator1: " + pairManipulator1 + "\npairManipulator2: " + pairManipulator2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pm1 = new PairManager1(),
                pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}
