package chapters.twenty_one.concurrency.modelling.restaurant;

import chapters.nineteen.enums.categories.menu.Food;

// Повар возвращает готовое блюдо:
class Plate {
    private final Order order;
    private final Food food;

    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public Order getOrder() {
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
