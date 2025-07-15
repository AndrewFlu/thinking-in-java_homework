package chapters.twenty_one.concurrency.modelling.car_builder;

import java.util.concurrent.BrokenBarrierException;

abstract class AbstractRobot implements Runnable {
    private RobotPool pool;
    private boolean engage = false;


    protected Assembler assembler;

    public AbstractRobot(RobotPool pool) {
        this.pool = pool;
    }

    public AbstractRobot assignAssembler(Assembler assembler) {
        this.assembler = assembler;

        return this;
    }

    public synchronized void engage() {
        engage = true;
        notifyAll(); // todo: для чего?
    }

    // Часть run(), отличная для каждого робота:
    protected abstract void performService();

    @Override
    public void run() {
        try {
            powerDown(); // Ожидать, пока не понадобится
            while (!Thread.interrupted()) {
                performService();
                assembler.getBarrier().await(); // Синхронизация

                // Задание выполнено:
                powerDown();
            }
        } catch (BrokenBarrierException e) {
            // Исключение, о котором нужно знать
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        }
        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; // Отключение от Assembler
        pool.release(this); // Возвращение в пул
        while (engage == false) // Выключение питания
            wait();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
