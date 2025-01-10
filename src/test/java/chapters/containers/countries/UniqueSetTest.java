package chapters.containers.countries;

import java.util.*;

public class UniqueSetTest {
    public static void main(String[] args) {
        List<String> countryNames = Countries.countryNames(10);
        // add duplicate values
        countryNames.addAll(Countries.countryNames(11));
        // set implementations
        Set<String> hashSet = new HashSet<>(countryNames);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(countryNames);
        TreeSet<String> treeSet = new TreeSet<>(countryNames);


        System.out.println("List: " + countryNames);
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);
    }
}
