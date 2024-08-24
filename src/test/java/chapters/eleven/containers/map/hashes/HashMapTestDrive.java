package chapters.eleven.containers.map.hashes;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapTestDrive {
    public static void main(String[] args) {
        Map<String, Integer> smeta = new HashMap<>();
        smeta.put("стены", 50000);
        smeta.put("пол", 100000);
        smeta.put("потолок", 50000);
        smeta.put("санузел", 250000);
        smeta.put("дверь", 40000);
        smeta.put("мебель", 100000);

        System.out.println(smeta);
        Set<String> keySet = smeta.keySet();
        Set<String> sortedSet = new TreeSet<>(keySet);

        Map<String, Integer> sorted = new LinkedHashMap<>();
        for (String s : sortedSet) {
            sorted.put(s, smeta.get(s));
        }
        System.out.println(sorted);
    }
}
