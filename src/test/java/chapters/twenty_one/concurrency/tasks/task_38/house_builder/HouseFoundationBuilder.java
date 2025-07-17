package chapters.twenty_one.concurrency.tasks.task_38.house_builder;

import java.util.concurrent.TimeUnit;

public class HouseFoundationBuilder implements Runnable {

    private int counter = 0;

    private BuildingQueue buildingQueue;

    public HouseFoundationBuilder(BuildingQueue houseFoundationQueue) {
        buildingQueue = houseFoundationQueue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(700);
                // Заливка фундамента:
                House house = new House(counter++);
                System.out.println("Залит фундамент для дома " + house);
                // Помещение в очередь
                buildingQueue.put(house);

            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: HouseFoundationBuilder");
        }
        System.out.println("HouseFoundationBuilder off");
    }
}
