package chapters.eleven.containers.list.listiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTestDrive {
    public static void main(String[] args) {
        List<Integer> forwardNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            forwardNumbers.add(i * 10);
        }

        List<Integer> reverseNumbers = new ArrayList<>(forwardNumbers.size());
        fillListWithReverseOrder(forwardNumbers, reverseNumbers);

        System.out.println("Список в прямом порядке" + forwardNumbers);
        System.out.println("Список в обратном порядке" + reverseNumbers);
    }

    private static void fillListWithReverseOrder(List<Integer> source, List<Integer> target) {
        ListIterator<Integer> integerListIterator = source.listIterator(source.size());

        while(integerListIterator.hasPrevious()) {
            target.add(integerListIterator.previous());
        }
    }
}
