package chapters.fifteen.generics.mixins.decorator.homework;

public class DecoFoamCoffee extends CoffeeDecorator {
    private static final String foam = "Красивая пенка";

    private final Coffee basicCoffee;

    public DecoFoamCoffee(Coffee basicCoffee) {
        super(basicCoffee);
        this.basicCoffee = basicCoffee;

    }

    public String getFoam() {
        return foam;
    }

    @Override
    public String toString() {
        return basicCoffee + " с фишечкой: " + getFoam();
    }
}
