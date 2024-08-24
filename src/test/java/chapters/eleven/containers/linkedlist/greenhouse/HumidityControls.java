package chapters.eleven.containers.linkedlist.greenhouse;

public class HumidityControls extends GreenHouseControls {
    private boolean humidityOn = false;

    public class HumidityOn extends Event {
        public HumidityOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управлением включением системы увлажнения
            humidityOn = true;
        }
        @Override
        public String toString() {
            return "Система увлажения включена";
        }
    }
    public class HumidityOff extends Event {
        public HumidityOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // код управлением отключения сиситемой увлажнения
            humidityOn = false;
        }

        @Override
        public String toString() {
            return "Система увлажнения отключена";
        }
    }
}
