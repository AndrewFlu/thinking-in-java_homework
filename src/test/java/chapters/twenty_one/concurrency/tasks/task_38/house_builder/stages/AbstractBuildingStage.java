package chapters.twenty_one.concurrency.tasks.task_38.house_builder.stages;

import chapters.twenty_one.concurrency.tasks.task_38.house_builder.Assembler;
import chapters.twenty_one.concurrency.tasks.task_38.house_builder.BuildingStagesPool;

import java.util.concurrent.BrokenBarrierException;

public abstract class AbstractBuildingStage implements Runnable {

    private BuildingStagesPool pool;

    public AbstractBuildingStage(BuildingStagesPool pool) {
        this.pool = pool;
    }

    protected Assembler assembler;

    public AbstractBuildingStage assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    protected abstract void performService();

    @Override
    public void run() {
        try {
            powerDown(); // Ожидать, пока не понадобится
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await(); // Синхронизация
                // Задание выполнено
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e); // Исключение, о котором нужно знать
        }

        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; // Отключение от Assembler
        pool.release(this); // Возвращение в пул

        while (engage == false)
            wait(); // Выключение питания
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
