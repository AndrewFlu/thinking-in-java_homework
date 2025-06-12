package chapters.twenty_one.concurrency.cooperation.notify_natifyall;

public class Task implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
