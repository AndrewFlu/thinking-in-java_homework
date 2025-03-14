package chapters.seventeen.containers.weakhashmap;

import java.util.WeakHashMap;

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        // Или использовать размер, заданный в командной строке
        if (args.length > 0)
            size = Integer.parseInt(args[0]);
        Key[] keyArray = new Key[size];
        WeakHashMap<Key, Value> weakHashMap = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0)
                keyArray[i] = k; // сохраняем как "настоящие" ссылки
            weakHashMap.put(k, v);
        }
        System.gc();
    }
}
