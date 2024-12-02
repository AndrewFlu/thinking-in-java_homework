package chapters.fifteen.generics.mixins;

public class Mixin extends BasicImpl implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImpl();
    private SerialNumbered serialNumbered = new SerialNumberedImpl();


    @Override
    public long getSerialNumbered() {
        return serialNumbered.getSerialNumbered();
    }

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }
}
