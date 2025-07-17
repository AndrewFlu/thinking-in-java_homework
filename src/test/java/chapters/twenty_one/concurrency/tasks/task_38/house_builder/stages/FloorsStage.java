package chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.BuildingStagesPool;

public class FloorsStage extends AbstractBuildingStage {

    public FloorsStage(BuildingStagesPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " building Floors");
        assembler.house().addFloors();
    }
}
