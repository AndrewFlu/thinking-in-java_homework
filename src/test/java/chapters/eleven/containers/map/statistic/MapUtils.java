package chapters.eleven.containers.map.statistic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUtils {
    public static LinkedHashMap<Integer, Integer> getSortedByValuesMap(Map<Integer, Integer> map) {
         return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())

                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}
