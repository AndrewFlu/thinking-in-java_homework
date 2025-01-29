package chapters.eleven.containers.map;

import chapters.containers.lightweight.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

import static net.midview.Print.print;

public class SortedMapOperations {
    public static void main(String[] args) {
        CountingMapData mapData = new CountingMapData(10);
        TreeMap<Integer, String> sortedMap = new TreeMap<>(mapData);
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println(low);
        System.out.println(high);
        Iterator<Integer> iterator = sortedMap.keySet().iterator();
        for (int i = 0; i < 6; i++) {
            if(i == 3)
                low = iterator.next();
            if (i <= 6)
                high = iterator.next();
            else
                iterator.next();
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.headMap(high));
        System.out.println(sortedMap.tailMap(low));

    }
}
