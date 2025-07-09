package chapters.twenty_one.concurrency.modelling;

import java.util.concurrent.ArrayBlockingQueue;

// Очередь клиентов умеет выводить своё состояние:
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (Customer customer : this)
            result.append(customer);
        return result.toString();
    }
}
