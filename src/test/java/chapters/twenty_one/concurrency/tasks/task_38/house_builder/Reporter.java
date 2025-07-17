package chapters.twenty_one.concurrency.tasks.task_38.house_builder;

public class Reporter implements Runnable {

    private BuildingQueue buildingQueue;

    public Reporter(BuildingQueue buildingQueue) {
        this.buildingQueue = buildingQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(buildingQueue.take() + "\n");
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}
