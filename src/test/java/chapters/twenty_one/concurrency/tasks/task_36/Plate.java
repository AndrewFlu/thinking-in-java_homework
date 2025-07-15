package chapters.twenty_one.concurrency.tasks.task_36;

import chapters.nineteen.enums.categories.menu.Food;

// Повар возвращает готовое блюдо:
class Plate {
    private final OrderTicket order;
    private final Food food;

    public Plate(OrderTicket order, Food food) {
        this.order = order;
        this.food = food;
    }

    public OrderTicket getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}
