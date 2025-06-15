package chapters.twenty_one.concurrency.tasks.task_25_26;

class Meal {
    private final int orderNumber;

    public Meal(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Meal " + "orderNumber=" + orderNumber;
    }
}
