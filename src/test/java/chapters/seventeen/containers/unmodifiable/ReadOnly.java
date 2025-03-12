package chapters.seventeen.containers.unmodifiable;

import chapters.containers.countries.Countries;

import java.util.*;

public class ReadOnly {
    static Collection<String> data = new ArrayList<String>(Countries.countryNames(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);
//        c.add("one");  ! unsupported operation exception
        List<String> list = Collections.unmodifiableList(new ArrayList<>(data));
        System.out.println(list.get(0));
//        System.out.println(list.add("two")); ! unsupported operation exception
        ListIterator<String> lit = list.listIterator();
        System.out.println(lit.next());
//        lit.add("three"); ! unsupported operation exception
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(set);
//        set.add("four"); ! unsupported operation exception
        SortedSet<String> sortedSet = Collections.unmodifiableSortedSet(new TreeSet<>(data));
        System.out.println(sortedSet);
        Map<String, String> map = Collections.unmodifiableMap(new HashMap<>(Countries.countries(5)));
        System.out.println(map);
//        map.put("five", "5"); ! unsupported operation exception
        SortedMap<String, String> sortedMap = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.countries(4)));
        System.out.println(sortedMap);
    }
}
