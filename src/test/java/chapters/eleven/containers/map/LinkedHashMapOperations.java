package chapters.eleven.containers.map;

import chapters.containers.lightweight.CountingMapData;

import java.util.LinkedHashMap;

public class LinkedHashMapOperations {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(10));
        System.out.println(linkedMap);
        // Порядок LRU (last-recently-used)
        linkedMap = new LinkedHashMap<>(15, 0.75f, true);
        linkedMap.putAll(new CountingMapData(10));
        System.out.println(linkedMap);
        // обращения к элементам с целью перестроить порядок в LinkedHashMap согласно LRU
        for (int i = 0; i < 6; i++) {
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
        System.out.println("last key of linkedMap: " + linkedMap.lastEntry().getKey());
        System.out.println("linkedMap.get(0): " + linkedMap.get(0));
        System.out.println("last key of linkedMap: " + linkedMap.lastEntry().getKey());
        System.out.println(linkedMap);
    }
}
