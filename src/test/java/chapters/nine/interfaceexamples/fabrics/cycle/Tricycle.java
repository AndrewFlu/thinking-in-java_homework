package chapters.nine.interfaceexamples.fabrics.cycle;

public class Tricycle implements ICycle {
    private static final int WHEELS_COUNT = 3;
    private static final boolean CAN_STAND = true;

    @Override
    public int getWheels() {
        return WHEELS_COUNT;
    }

    @Override
    public void drive() {
        System.out.println("Ехать на трицикле");
    }

    @Override
    public boolean canStand() {
        return CAN_STAND;
    }
}
