package chapters.fifteen.generics.sets;

import java.lang.reflect.Method;
import java.util.*;

import static net.midview.Print.print;

public class ContainerMethodDifferences {

    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<String>();
        for (Method m : type.getMethods()) {
            result.add(m.getName());
        }

        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> compute = Sets.difference(methodSet(superset), methodSet(subset));
        // не показывать методы Object
        compute.removeAll(object);
        System.out.println(compute);
        interfaces(superset);
    }

    // test-drive
    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));

        interfaces(Collection.class);
        print("");
        difference(Set.class, Collection.class);
        print("");
        difference(HashSet.class, Set.class);
        print("");
        difference(LinkedHashSet.class, HashSet.class);
        print("");
        difference(TreeSet.class, Set.class);
        print("");
        difference(List.class, Collection.class);
        print("");
        difference(Queue.class, Collection.class);
        print("");
        difference(PriorityQueue.class, Queue.class);
        print("");

        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        print("");
        difference(LinkedHashMap.class, HashMap.class);
        print("");
        difference(SortedMap.class, Map.class);
        print("");
        difference(TreeMap.class, Map.class);
    }
}
