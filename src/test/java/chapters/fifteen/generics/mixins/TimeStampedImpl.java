package chapters.fifteen.generics.mixins;

import java.util.Date;

public class TimeStampedImpl implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImpl() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}
