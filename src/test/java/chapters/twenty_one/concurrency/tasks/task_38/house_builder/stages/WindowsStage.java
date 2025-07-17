package chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.BuildingStagesPool;

public class WindowsStage extends AbstractBuildingStage {

    public WindowsStage(BuildingStagesPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Windows");
        assembler.house().addWindows();
    }
}
