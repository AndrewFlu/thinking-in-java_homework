package chapters.twenty_one.concurrency.tasks.task_38.house_builder;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages.AbstractBuildingStage;

import java.util.HashSet;
import java.util.Set;

public class BuildingStagesPool {
    // Незаметно предотвращает использование идентичных элементов
    private Set<AbstractBuildingStage> pool = new HashSet<>();

    public synchronized void addStage(AbstractBuildingStage stage) {
        pool.add(stage);
        notifyAll();
    }

    public synchronized void hire(Class<? extends AbstractBuildingStage> stageClass, Assembler assembler) throws InterruptedException {
        for (AbstractBuildingStage stage : pool) {
            if (stageClass.equals(stage.getClass())) {
                pool.remove(stage);
                stage.assignAssembler(assembler);
                stage.engage(); // Включение для выполнения задания
                return;
            }
        }
        // Нет доступных кандидатов. Повторная попытка с рекурсией
        wait();
        hire(stageClass, assembler);
    }

    public synchronized void release(AbstractBuildingStage stage) {
        addStage(stage);
    }
}
