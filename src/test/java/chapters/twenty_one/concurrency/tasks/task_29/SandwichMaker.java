package chapters.twenty_one.concurrency.tasks.task_29;

// Put peanutButtered and jellied toast together
public class SandwichMaker implements Runnable {

    private int count = 0;
    private ToastQueue peanutButteredQueue, jelliedQueue;
    private SandwichQueue sandwichQueue;

    public SandwichMaker(ToastQueue peanutButteredQueue, ToastQueue jelliedQueue, SandwichQueue sandwichQueue) {
        this.peanutButteredQueue = peanutButteredQueue;
        this.jelliedQueue = jelliedQueue;
        this.sandwichQueue = sandwichQueue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Sandwich sandwich = new Sandwich(jelliedQueue.take(), peanutButteredQueue.take(), count++);
                System.out.println(sandwich);
                sandwichQueue.put(sandwich);
            }
        } catch (InterruptedException e) {
            System.out.println("SandwichMaker interrupted");
        }
        System.out.println("SandwichMaker off");
    }
}

