package chapters.eight.sandwich;

public class Sandwich extends PortableLunch {
    private final Bread bread = new Bread();
    private final Cheese cheese = new Cheese();
    private final Lettuce lettuce = new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
