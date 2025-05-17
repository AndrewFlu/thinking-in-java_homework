package chapters.twenty_one.concurrency.tasks.task_11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankOperation implements Runnable {

    private Account account;

    public BankOperation(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (account.isActive()) {
            int increasedAmount = account.increaseAmount();
            System.out.println(account);
            if (increasedAmount % 2 != 0) {
                System.out.println("The increased amount [" + increasedAmount +
                        "] doesn't even!)");
                account.setLocked();
            }
        }
    }

    public static void check(int count, Account account) {
        System.out.println("Press Ctrl+C to exit");

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < count; i++) {
            executor.execute(new BankOperation(account));
        }
        executor.shutdown();
    }
}
