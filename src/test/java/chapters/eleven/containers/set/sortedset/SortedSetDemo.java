package chapters.eleven.containers.set.sortedset;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet,
                "one two three four five six seven eight nine".split(" "));
        System.out.println(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i < 7; i++) {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else it.next();
        }
        System.out.println();
        System.out.println(low);
        System.out.println(high);
        System.out.println("subset: " + sortedSet.subSet(low, high));
        System.out.println("set: " + sortedSet);
        System.out.println("head set: " + sortedSet.headSet(high) + " with high: " + high);
        System.out.println("tail set: " + sortedSet.tailSet(low) + " with low: " + low);

    }
}
