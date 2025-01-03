package chapters.containers.generators;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), new Government().foundation.length));
        // использование вспомогательного метода
        set.addAll(CollectionData.list(new Government(), 7));
        System.out.println(set);
    }
}
