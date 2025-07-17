package chapters.twenty_one.concurrency.tasks.task_38.house_builder;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.FloorsStage;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.RoofStage;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.WallsStage;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.WindowsStage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Assembler implements Runnable {

    private static final int STAGES_COUNT = 4;
    private static final int MAIN_THREADS_COUNT = 1;

    private BuildingQueue houseFoundationQueue = new BuildingQueue();
    private BuildingQueue finishingQueue = new BuildingQueue();

    private House house;
    private CyclicBarrier barrier = new CyclicBarrier(STAGES_COUNT + MAIN_THREADS_COUNT);
    private BuildingStagesPool stagesPool;

    public Assembler(BuildingQueue houseFoundationQueue, BuildingQueue finishingQueue, BuildingStagesPool stagesPool) {
        this.houseFoundationQueue = houseFoundationQueue;
        this.finishingQueue = finishingQueue;
        this.stagesPool = stagesPool;
    }

    public House house() {
        return house;
    }

    public CyclicBarrier barrier() {
        return barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                house = houseFoundationQueue.take();

                // выполнение всех этапов работ
                stagesPool.hire(WallsStage.class, this);
                stagesPool.hire(WindowsStage.class, this);
                stagesPool.hire(RoofStage.class, this);
                stagesPool.hire(FloorsStage.class, this);

                barrier.await(); // Ожидать, пока не будут выполнены все стадии строительства

                finishingQueue.put(house); // здание помещается в очередь для дальнейшей работы
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e); // Исключение, о котором нужно знать
        }
        System.out.println("Assembler off");
    }
}
