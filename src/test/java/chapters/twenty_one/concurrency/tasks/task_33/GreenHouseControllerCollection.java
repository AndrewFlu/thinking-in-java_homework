package chapters.twenty_one.concurrency.tasks.task_33;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;

public class GreenHouseControllerCollection extends GreenHouseController {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public GreenHouseControllerCollection(DelayQueue<AbstractEvent> g) {
        super(g);
    }

    public static class Terminate extends AbstractEvent {
        private ExecutorService exec;

        public Terminate(long delayTime, ExecutorService exec) {
            super(delayTime);
            this.exec = exec;
        }

        @Override
        public void run() {
            exec.shutdownNow();
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public class LightOn extends AbstractEvent {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            // Поместите сюда код управления оборудованием,
            // выполняющий непосредственное включение света
            light = true;
        }

        @Override
        public String toString() {
            return "Turning on lights";
        }
    }

    public class LightOff extends AbstractEvent {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            // Поместите сюда код управления оборудованием,
            // выполняющий непосредственное выключение света
            light = false;
        }

        @Override
        public String toString() {
            return "Turning off lights";
        }
    }

    public class WaterOn extends AbstractEvent {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            // Здесь размещается код управления оборудованием
            water = true;
        }

        @Override
        public String toString() {
            return "Turning greenhouse water on";
        }
    }

    public class WaterOff extends AbstractEvent {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            // Здесь размещается код управления оборудованием
            water = false;
        }

        @Override
        public String toString() {
            return "Turning greenhouse water off";
        }
    }

    public class ThermostatNight extends AbstractEvent {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            // Здесь размещается код управления оборудованием
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat to night setting";
        }
    }

    public class ThermostatDay extends AbstractEvent {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            // Здесь размещается код управления оборудованием
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat to day setting";
        }
    }

    public class Bell extends AbstractEvent {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void run() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends AbstractEvent {

        private AbstractEvent[] eventList;

        public Restart(long delayTime, AbstractEvent[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (AbstractEvent event : eventList)
                addEvent(event);
        }


        @Override
        public void run() {
            for (AbstractEvent event : eventList)
                addEvent(event);
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }
}
