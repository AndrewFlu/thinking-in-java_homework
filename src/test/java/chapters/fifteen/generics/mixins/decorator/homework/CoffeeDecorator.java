package chapters.fifteen.generics.mixins.decorator.homework;

public class CoffeeDecorator extends Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getType() {
        return coffee.getType();
    }

    @Override
    public void setType(String type) {
        coffee.setType(type);
    }
}
