package chapters.fifteen.generics.mixins.decorator.homework;

public class CoffeeDecoratorTestDrive {
    public static void main(String[] args) {
        Coffee cappuccino = new Cappuccino();
        System.out.println(cappuccino);
        ChocolateCappuccino chocolateCappuccino = new ChocolateCappuccino(new Cappuccino());
        System.out.println(chocolateCappuccino);
        System.out.println(chocolateCappuccino.getTopping());

        Cappuccino cappuccino1 = new Cappuccino();
        DecoFoamCoffee decoFoamCoffee = new DecoFoamCoffee(cappuccino1);
        System.out.println(decoFoamCoffee);

        CoffeeDecorator caramelCappuccino = new Caramel(new Cappuccino());
        System.out.println(caramelCappuccino);
    }
}
