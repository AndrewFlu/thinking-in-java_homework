package chapters.eleven.containers.map.gerbil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GerbilTEstDrive {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbilMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            gerbilMap.put(String.valueOf(i), new Gerbil(i));
        }
        Set<String> keySet = gerbilMap.keySet();
        for (String s : keySet) {
            gerbilMap.get(s).hop();
        }
    }
}
