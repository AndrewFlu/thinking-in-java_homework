package chapters.eleven.containers.hashes;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {
    // Используем GroundHog или класс, производный от него
    public static <T extends GroundHog> void detectSprint(Class<T> type) throws Exception {
        Constructor<T> constructor = type.getConstructor(int.class);
        Map<GroundHog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(constructor.newInstance(i), new Prediction());
        }
        System.out.println("map: " + map);
        GroundHog groundHog3 = constructor.newInstance(3);
        System.out.println();
        System.out.println("Look up prediction for " + groundHog3 + "...");
        if (map.containsKey(groundHog3))
            System.out.println(map.get(groundHog3));
        else
            System.out.println("Key not found: " + groundHog3);
    }

    public static void main(String[] args) throws Exception {
        detectSprint(GroundHog.class);
    }
}
