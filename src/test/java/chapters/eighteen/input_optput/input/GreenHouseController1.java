package chapters.eighteen.input_optput.input;

import chapters.ten.greenhouse.Event;
import chapters.ten.greenhouse.GreenHouseControls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GreenHouseController1 {
    // To read events from text file and add to HashMap<String, Long>:
    public static Map<String, Long> readEvents(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        Map<String, Long> map = new HashMap<>();
        while ((s = in.readLine()) != null) {
            String[] split = s.split("[()]");
            map.put(split[0], Long.parseLong(split[1]));
        }
        in.close();

        return map;
    }

    // To build Event objects from Map.Entry objects
    private static Event makeEvent(GreenHouseControls gc, Map.Entry<String, Long> me) {
        String key = me.getKey();
        Long value = me.getValue();
        return switch (key) {
            case "Bell" -> gc.new Bell(value);
            case "LightOn" -> gc.new LightOn(value);
            case "LightOff" -> gc.new LightOff(value);
            case "WaterOn" -> gc.new WaterOff(value);
            case "WaterOff" -> gc.new WaterOff(value);
            case "ThermostatDay" -> gc.new ThermostatDay(value);
            default -> null;
        };
    }

    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information  from a text file here:
        try {
            // Read text and convert lines to map entries:
            Map<String, Long> map = readEvents("events.txt");
            Event[] events = new Event[map.size()];
            int i = 0;
            // Make events from map and add to Events array:
            for (Map.Entry<String, Long> mapEntry : map.entrySet()) {
                events[i++] = makeEvent(gc, mapEntry);
            }
            gc.addEvent(gc.new Restart(2000, events));
            if (args.length == 1) {
                gc.addEvent(new GreenHouseControls.Terminate(Integer.parseInt(args[0])));
            }
            gc.run();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
