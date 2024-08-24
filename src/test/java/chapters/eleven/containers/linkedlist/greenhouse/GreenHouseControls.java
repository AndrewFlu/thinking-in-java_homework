package chapters.eleven.containers.linkedlist.greenhouse;

/**
 * Пример конкретного приложения на основе системы управления,
 * всё находится в одном колассе. Внутрнние классы дают возможность
 * инкапсулировать различную функциональность для каждого отдельного события
 */
public class GreenHouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управления оборудованием включения света
            light = true;
        }

        @Override
        public String toString() {
            return "Свет включён";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код упарвления оборудование отключения света
            light = false;
        }

        @Override
        public String toString() {
            return "Свет выключен";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управления оборудованием включения полива
            water = true;
        }

        @Override
        public String toString() {
            return "Полив включён";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управления отключением полива
            water = false;
        }

        @Override
        public String toString() {
            return "Полив выключен";
        }
    }

    public String thermostat = "День";

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управлением переключением термостата на ночной режим
            thermostat = "Ночь";
        }

        @Override
        public String toString() {
            return "Термостат использует ночной режим";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управления переключением термостата на дневной режим
            thermostat = "День";
        }

        @Override
        public String toString() {
            return "Термостат использует дневной режим";
        }
    }

    public boolean airConditioning = false;
    public class AirConditioningOn extends Event {
        public AirConditioningOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управлением включения кондиционирования помещения
            airConditioning = true;
        }

        @Override
        public String toString() {
            return "Помещение проветривается";
        }
    }
    public class AirConditioningOff extends Event {
        public AirConditioningOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управлением отключения кондиционированием помещения
            airConditioning = false;
        }

        @Override
        public String toString() {
            return "Проветривание выключено";
        }
    }

    /**
     * Пример метода action(), вставляющего новый экземпляр самого себя в список событий
     */
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Дзынь!";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }

        public Restart(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); // перезапуск каждого события
                addEvent(e);
            }

            start(); // перезапуск текущего события
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Перезапуск системы";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Отключение";
        }
    }
}
