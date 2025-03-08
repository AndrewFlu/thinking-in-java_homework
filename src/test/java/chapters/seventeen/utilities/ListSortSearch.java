package chapters.seventeen.utilities;

import java.util.*;

import static net.midview.Print.print;

public class ListSortSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println("list: " + list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffled list: " + list);
        // Использование ListIterator для отсечения последних элементов
        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        print("trimmed: " + list);
        Collections.sort(list);
        print("sorted: " + list);
        String key = list.get(7);
        int index = Collections.binarySearch(list, key);
        System.out.println("location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("case insensitive order: " + list);

        key = list.get(7);
        index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        System.out.println("location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
    }
}
