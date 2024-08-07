package chapters.nine.interfaceexamples.fabrics.cycle;

public class Unicycle implements ICycle {
    private static final int WHEELS_COUNT = 1;
    private static final boolean CAN_STAND = false;

    @Override
    public int getWheels() {
        return WHEELS_COUNT;
    }

    @Override
    public void drive() {
        System.out.println("Ехать на моноколесе");
    }

    @Override
    public boolean canStand() {
        return CAN_STAND;
    }
}
