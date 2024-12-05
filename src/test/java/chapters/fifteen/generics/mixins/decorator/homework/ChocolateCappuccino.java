package chapters.fifteen.generics.mixins.decorator.homework;

public class ChocolateCappuccino extends CoffeeDecorator {
    private static final String topping = "Шоколад";

    private final Coffee basicCoffee;

    public ChocolateCappuccino(Coffee basicCoffee) {
        super(basicCoffee);
        this.basicCoffee = basicCoffee;
    }

    @Override
    public String toString() {
        return basicCoffee + " с топпингом: " + topping;
    }

    public String getTopping() {
        return topping;
    }
}
