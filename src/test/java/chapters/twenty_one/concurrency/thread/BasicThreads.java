package chapters.twenty_one.concurrency.thread;

import chapters.twenty_one.concurrency.runnable.LiftOff;

public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff()");
    }
}
