package chapters.nine.interfaceexamples.sandwitch;

public class Sandwich extends PortableLunch implements ISandwich {
    private final Bread bread = new Bread();
    private final Cheese cheese = new Cheese();
    private final Lettuce lettuce = new Lettuce();
    private final Pickle pickle = new Pickle();

    @Override
    public void getClassic() {
        System.out.println("Классический сэндвич");
    }

    @Override
    public void getUnHealthy() {
        System.out.println("Вредный сендвич");
    }

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        ISandwich sandwich = new Sandwich();
        sandwich.getClassic();
        sandwich.getUnHealthy();
    }
}
