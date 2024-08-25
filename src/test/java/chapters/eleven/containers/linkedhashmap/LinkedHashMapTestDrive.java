package chapters.eleven.containers.linkedhashmap;

import java.util.LinkedHashMap;

import static chapters.eleven.containers.map.statistic.MapUtils.getSortedByKeysMap;

public class LinkedHashMapTestDrive {
    public static void main(String[] args) {
        LinkedHashMap<String, String> renovation = new LinkedHashMap<>();
        renovation.put("пол в ванной", "керамогранит");
        renovation.put("пол на кухне", "керамогранит");
        renovation.put("пол в прихожей", "керамогранит");
        renovation.put("пол в зале", "кварцивинил");
        renovation.put("потолок", "натяжной");
        renovation.put("стены", "обои");
        renovation.put("гарнитур", "одноэтажный");

        System.out.println("До сортировки:");
        printMap(renovation);

        System.out.println();
        System.out.println("После сортировки по ключам:");
        LinkedHashMap<String, String> sortedByKeysMap = getSortedByKeysMap(renovation);
        printMap(sortedByKeysMap);
    }

    private static void printMap(LinkedHashMap<String, String> map) {
        for (String s : map.keySet()) {
            System.out.print(s + ": ");
            System.out.println(map.get(s));
        }
    }
}
