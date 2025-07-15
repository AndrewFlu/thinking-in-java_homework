package chapters.twenty_one.concurrency.modelling.car_builder;

import java.util.HashSet;
import java.util.Set;

class RobotPool {
    // Незаметно предотвращает использование идентичных элементов
    private Set<AbstractRobot> pool = new HashSet<>();

    public synchronized void add(AbstractRobot r) {
        pool.add(r);
        notifyAll(); // todo: кого уведомляет?
    }

    public synchronized void hire(Class<? extends AbstractRobot> robotType, Assembler assembler) throws InterruptedException {
        for (AbstractRobot robot : pool) {
            if (robot.getClass().equals(robotType)) {
                pool.remove(robot);
                robot.assignAssembler(assembler);
                robot.engage(); // Включение для выполнения задания

                return;
            }
        }
        wait(); // Нет доступных кандидатов
        hire(robotType, assembler); // повторная попытка с рекурсией
    }

    public synchronized void release(AbstractRobot robot) {
        add(robot);
    }
}
