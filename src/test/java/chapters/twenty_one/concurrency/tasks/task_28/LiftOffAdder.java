package chapters.twenty_one.concurrency.tasks.task_28;

import chapters.twenty_one.concurrency.runnable.LiftOff;

public class LiftOffAdder implements Runnable {

    private LiftOffRunner runner;

    public LiftOffAdder(LiftOffRunner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(3));
        }
    }
}
