package chapters.eight.cycles;

public class Unicycle extends Cycle {
    private final int wheels = 1;

    public void ride() {
        System.out.println("Ехать на моноцикле");
        super.ride();
    }

    @Override
    public int wheels() {
        return wheels;
    }

    public void balance() {
        System.out.println("Ловим баланс на моноцикле");
    }
}
