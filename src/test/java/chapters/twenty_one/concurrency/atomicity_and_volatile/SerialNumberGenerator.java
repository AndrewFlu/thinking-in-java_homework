package chapters.twenty_one.concurrency.atomicity_and_volatile;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++; // небезопасно для потоков
    }
}
