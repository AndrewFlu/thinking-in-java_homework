package chapters.eight.cycles;

public class Tricycle extends Cycle{
    private final int wheels = 3;

    public void ride() {
        System.out.println("Ехать на трицикле");
        super.ride();
    }

    @Override
    public int wheels() {
        return wheels;
    }
}
