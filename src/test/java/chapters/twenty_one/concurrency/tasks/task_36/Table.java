package chapters.twenty_one.concurrency.tasks.task_36;

import java.util.List;

public class Table {
    private final TableNumber id;
    private List<Customer> customers;

    public Table(TableNumber id, List<Customer> customers) {
        this.id = id;
        this.customers = customers;
    }

    public enum TableNumber {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
    }

    @Override
    public String toString() {
        return "Стол номер [" + id + "], клиентов: " + customers.size();
    }
}
