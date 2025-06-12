package chapters.twenty_one.concurrency.cooperation.notify_natifyall;

public class Task2 implements Runnable {

    // Отдельный объект Blocker
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
