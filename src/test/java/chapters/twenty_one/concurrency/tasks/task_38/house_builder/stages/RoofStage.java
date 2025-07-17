package chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.BuildingStagesPool;

public class RoofStage extends AbstractBuildingStage {

    public RoofStage(BuildingStagesPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " building Roof");
        assembler.house().addRoof();
    }
}
