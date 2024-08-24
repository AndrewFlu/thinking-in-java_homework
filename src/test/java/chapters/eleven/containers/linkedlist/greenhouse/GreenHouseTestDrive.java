package chapters.eleven.containers.linkedlist.greenhouse;

/**
 * Настройка и запуск системы управления
 * {args: 5000}
 */
public class GreenHouseTestDrive {
    public static void main(String[] args) {
        HumidityControls ghController = new HumidityControls();

        ghController.addEvent(ghController.new Bell(900));

        Event[] eventList = {
                ghController.new ThermostatNight(0),
                ghController.new HumidityOn(300),
                ghController.new LightOn(200),
                ghController.new AirConditioningOn(250),
                ghController.new LightOff(400),
                ghController.new HumidityOff(500),
                ghController.new WaterOn(600),
                ghController.new WaterOff(800),
                ghController.new ThermostatDay(1400),
                ghController.new AirConditioningOff(1500)
        };

        ghController.addEvent(ghController.new Restart(2000, eventList));

        if (args.length == 1) {
            ghController.addEvent(new GreenHouseControls.Terminate(Integer.parseInt(args[0])));
        }
        ghController.run();
    }
}
