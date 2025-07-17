package chapters.twenty_one.concurrency.tasks.task_38.house_builder;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.FloorsStage;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.RoofStage;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.WallsStage;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.WindowsStage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HomeBuilder {
    public static void main(String[] args) throws InterruptedException {
        BuildingQueue houseFoundationQueue = new BuildingQueue();
        BuildingQueue finishingQueue = new BuildingQueue();

        ExecutorService executor = Executors.newCachedThreadPool();
        BuildingStagesPool stagesPool = new BuildingStagesPool();

        executor.execute(new WallsStage(stagesPool));
        executor.execute(new WindowsStage(stagesPool));
        executor.execute(new FloorsStage(stagesPool));
        executor.execute(new RoofStage(stagesPool));

        executor.execute(new Assembler(houseFoundationQueue, finishingQueue, stagesPool));

        executor.execute(new Reporter(finishingQueue));

        // Строительство фундамента приводит стройку в движение:
        executor.execute(new HouseFoundationBuilder(houseFoundationQueue));
        TimeUnit.SECONDS.sleep(7);

        executor.shutdownNow();
    }
}
