package chapters.twenty_one.concurrency.producer_consumer.restaurant;

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
