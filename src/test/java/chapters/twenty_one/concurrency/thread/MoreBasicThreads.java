package chapters.twenty_one.concurrency.thread;

import chapters.twenty_one.concurrency.runnable.LiftOff;

public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }

        System.out.println("Waiting for liftOff()");
    }
}
