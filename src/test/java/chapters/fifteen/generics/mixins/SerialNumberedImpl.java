package chapters.fifteen.generics.mixins;

public class SerialNumberedImpl implements SerialNumbered {
    private static long counter;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumbered() {
        return serialNumber;
    }
}
