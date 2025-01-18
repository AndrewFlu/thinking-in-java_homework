package chapters.containers.countries;

import java.util.*;

public class ListTestDrive {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Countries.countryNames(5));
        List<String> linkedList = new LinkedList<>(Countries.countryNames(4));

        printListDetails(arrayList);
        printListDetails(linkedList);

        ListIterator<String> listIterator = linkedList.listIterator();
        for (String s : linkedList) {
            if (listIterator.hasNext()) {
                String next = listIterator.next();
                arrayList.add(next);
            }
        }
        printListDetails(arrayList);

        ListIterator<String> tailListIterator = linkedList.listIterator(linkedList.size());
        while (tailListIterator.hasPrevious()) {
            String previous = tailListIterator.previous();
            arrayList.add(previous);
        }

        printListDetails(arrayList);

    }

    private static void printListDetails(List<String> list) {
        System.out.println(list.getClass().getSimpleName() + ": ");
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
