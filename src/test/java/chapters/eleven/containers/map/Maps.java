package chapters.eleven.containers.map;

import chapters.containers.lightweight.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static net.mindview.utils.Print.print;

public class Maps {
    public static void printKeys(Map<Object, Object> map) {
        System.out.print("Size: " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.println(map.keySet());
    }

    public static void test(Map<Object, Object> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map реализует поведение 'Set' для ключей
        printKeys(map);
        // Создание коллекции значений
        System.out.print("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue('F0'): " + map.containsValue("F0"));
        var key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        print("map.isEmpty(): " + map.isEmpty());
        // Операции с Set изменяют Map
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
        test(new Properties());
    }
}
