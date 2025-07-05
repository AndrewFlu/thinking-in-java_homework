package chapters.twenty_one.concurrency.tasks.task_33;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GreenHouseScheduler_33 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<AbstractEvent> queue = new DelayQueue<>();
        GreenHouseControllerCollection controllers = new GreenHouseControllerCollection(queue);
        controllers.addEvent(controllers.new Bell(900));
        AbstractEvent[] eventList = {
                controllers.new ThermostatNight(0),
                controllers.new LightOn(200),
                controllers.new LightOff(400),
                controllers.new WaterOn(600),
                controllers.new WaterOff(800),
                controllers.new ThermostatDay(1000),
        };
        controllers.addEvent(controllers.new Restart(2000, eventList));
        if (args.length == 1)
            controllers.addEvent(new GreenHouseControllerCollection.Terminate(Integer.parseInt(args[0]), exec));
        exec.execute(controllers);
    }
}
