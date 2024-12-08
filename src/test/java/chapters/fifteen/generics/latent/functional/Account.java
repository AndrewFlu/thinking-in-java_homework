package chapters.fifteen.generics.latent.functional;

public class Account {
    private static long counter = 1;
    private final long id = counter++;
    private long balance;


    public Account() {
        this.balance = 0;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
