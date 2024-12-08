package chapters.fifteen.generics.latent.functional;

import java.util.Arrays;
import java.util.List;

import static chapters.fifteen.generics.latent.functional.Functional.*;

public class Functional2 {
    public static void main(String[] args) {
        List<Tank> tankList = Arrays.asList(
                new Tank(50),
                new Tank(45),
                new Tank(70)
        );

        List<Account> bankAccountList = Arrays.asList(
                new Account(),
                new Account(),
                new Account(),
                new Account()
        );
        bankAccountList.get(0).setBalance(10);
        bankAccountList.get(1).setBalance(500);
        bankAccountList.get(3).setBalance(1000_000);


        // 1. function object — reduce()
        Combiner<Tank> combiner = new TankCombiner();
        Tank reducedTank = reduce(tankList, combiner);
        System.out.println("New reduced tank has capacity: " + reducedTank.getCapacity());

        // 2. function object — foreach()
        Collector<Account> collector = new AccountCollector();
        Collector<Account> accountCollector = forEach(bankAccountList, collector);
        System.out.println(accountCollector.result());

        // 3. function object — transform
        UnaryFunction<?, Tank> transformFunction = new TankTransformer();
        transform(tankList, transformFunction);
        tankList.forEach(t -> System.out.println(t.getCapacity()));

        // 4. function object — filter
        UnaryPredicate<Account> accountPredicate = new PositiveBalancePredicate();
        List<Account> positiveBalanceAccounts = filter(bankAccountList, accountPredicate);
        System.out.println(positiveBalanceAccounts);
    }

    private static class AccountCollector implements Collector<Account> {
        private Account balance = new Account();

        @Override
        public Account result() {
            return balance;
        }

        @Override
        public Account function(Account x) {
            long balanceIncrease = balance.getBalance() + x.getBalance();
            balance.setBalance(balanceIncrease);

            return balance;
        }
    }

    private static class TankTransformer implements UnaryFunction<Tank, Tank> {
        @Override
        public Tank function(Tank x) {
            x.setCapacity(x.getCapacity() + 10);

            return x;
        }
    }

    private static class PositiveBalancePredicate implements UnaryPredicate<Account> {
        @Override
        public boolean test(Account x) {
            return x.getBalance() > 0;
        }
    }
}
