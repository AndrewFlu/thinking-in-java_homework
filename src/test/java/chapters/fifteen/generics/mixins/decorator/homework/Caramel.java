package chapters.fifteen.generics.mixins.decorator.homework;

public class Caramel extends CoffeeDecorator{
    private static final String topping = "карамель";

    private final Coffee basicCoffee;


    public Caramel(Coffee basicCoffee) {
        super(basicCoffee);
        this.basicCoffee  = basicCoffee;

    }

    @Override
    public String toString() {
        return basicCoffee + " с топпингом: " + topping;
    }
}
