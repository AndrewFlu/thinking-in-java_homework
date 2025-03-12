package chapters.seventeen.containers.synhcronized;

import java.util.*;

public class Synchronization {
    public static void main(String[] args) {
        Collection<String> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
        Set<String> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());
        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());
    }
}
