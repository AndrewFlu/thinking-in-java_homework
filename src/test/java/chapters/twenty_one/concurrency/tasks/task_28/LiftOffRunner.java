package chapters.twenty_one.concurrency.tasks.task_28;

import chapters.twenty_one.concurrency.runnable.LiftOff;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
    private final BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        this.rockets = queue;
    }

    public void add(LiftOff io) {
        try {
            rockets.put(io);
        } catch (InterruptedException e) {
            System.out.println("Interrupting during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run(); // использовать этот поток
            }

        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
