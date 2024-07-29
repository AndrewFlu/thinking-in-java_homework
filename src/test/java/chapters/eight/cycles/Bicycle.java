package chapters.eight.cycles;

public class Bicycle extends Cycle {
    private final int wheels = 2;

    public void ride() {
        System.out.println("Ехать на велосипеде");
        super.ride();
    }

    public int wheels() {
        return wheels;
    }
}
