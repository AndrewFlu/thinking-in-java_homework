package chapters.twenty_one.concurrency.tasks.task_33;

import java.util.concurrent.DelayQueue;

public class GreenHouseController implements Runnable{

    private DelayQueue<AbstractEvent> q;

    public GreenHouseController(DelayQueue<AbstractEvent> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                AbstractEvent event = q.take();
                System.out.println(event);
                event.run();
            }
        } catch (InterruptedException e) {
            System.out.println("GreenHouseController interrupted");
        }
        System.out.println("Finished GreenHouseController");
    }

    public void addEvent(AbstractEvent event ) {
        event.start();
        q.put(event);
    }
}
