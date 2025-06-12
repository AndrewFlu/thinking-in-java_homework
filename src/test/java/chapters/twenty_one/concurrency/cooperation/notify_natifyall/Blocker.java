package chapters.twenty_one.concurrency.cooperation.notify_natifyall;

public class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println("waitingCall() " + Thread.currentThread() + " ");
            }
        } catch (InterruptedException ignore) {
            // допустимый способ выхода
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}
