package chapters.twenty_one.concurrency.tasks.task_11;

public class Account extends AbstractAccount {
    private int id;
    private int amount;


    @Override
    public int increaseAmount() {
        ++amount;
        ++amount;

        return amount;
    }

    public String toString() {
        return "Account #" + id + " amount: " + amount;
    }
}
