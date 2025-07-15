package chapters.twenty_one.concurrency.tasks.task_36;

import chapters.nineteen.enums.categories.menu.Food;

// Заказ передаётся официанту,
// который передаёт его повару:
class OrderTicket {
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final Food food;
    private final Table table;

    public OrderTicket(Customer cust, WaitPerson wp, Food f, Table table) {
        customer = cust;
        waitPerson = wp;
        food = f;
        this.table = table;
    }

    public Food item() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    @Override
    public String toString() {
        return "Заказ: " + id +  " блюдо: " + food + " для: " + customer + ". Обслуживает: " + waitPerson
                + "доставляется на: " + table;
    }
}
