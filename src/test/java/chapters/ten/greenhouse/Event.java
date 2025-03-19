package chapters.ten.greenhouse;

/**
 * Общие для всякого управляющего события методы
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public abstract void action();

    // с возможностью перезапуска
    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
}
