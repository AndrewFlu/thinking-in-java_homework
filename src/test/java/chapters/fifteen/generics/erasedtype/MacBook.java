package chapters.fifteen.generics.erasedtype;

public class MacBook implements IPortablePc {
    private static final long BATTERY_CAPACITY = 10;
    private static final long AUTONOMOUS_DURATION = 18;
    private long batteryChargeState = 0;


    @Override
    public void charge() {
        System.out.println("Зарядка...");
        while (batteryChargeState < BATTERY_CAPACITY) {
            System.out.println("Текущий заряд: " + ++batteryChargeState);
        }
        if (batteryChargeState == BATTERY_CAPACITY) {
            System.out.println("Батарея заряжена");
        }
    }

    @Override
    public long getAutonomousWorkDuration() {
        return AUTONOMOUS_DURATION;
    }

    public void watchVideo() {
        if (batteryChargeState == 0) {
            System.out.println("Батарея разряжена");
            return;
        }
        while (batteryChargeState > 0) {
            System.out.println("Воспроизведение видео...");
            batteryChargeState--;
        }
        System.out.println("Батарея разряжена");
    }
}
