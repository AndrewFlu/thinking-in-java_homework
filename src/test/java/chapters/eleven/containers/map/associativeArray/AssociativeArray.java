package chapters.eleven.containers.map.associativeArray;

import chapters.eleven.containers.map.hashes.SimpleHashMap;
import chapters.eleven.containers.map.slowmap.SlowMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];

        return null; // ключ не найден
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }

        return result.toString();
    }

    // test-drive
    public static void main(String[] args) {
//        AssociativeArray<String, String> map = new AssociativeArray<>(5);
        Map<String, String> map;
//        map = new HashMap<>();
//        map = new TreeMap<>();
//        map = new LinkedHashMap<>();
        map = new SlowMap<>();
        map = new SimpleHashMap<>();

        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("sun", "hot");
        map.put("nature", "beautifull");
        map.put("air", "fresh");

        try {
            map.put("extraAttribute", "exception should be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Too many objects!");
        }

        System.out.println(map);
        System.out.println(map.get("nature"));
    }
}
