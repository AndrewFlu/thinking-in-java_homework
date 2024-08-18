package chapters.eleven.containers.addinggroups;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        // работает значительно быстрее, но Collection так сконструировать невозможно:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // создаёт список на базе массива
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 97); // ОК — изменить элемент
//        list.add(21); // ошибка времени выполлненимя: размер базового массива изменяться не может

        for (Integer i : collection) {
            System.out.println(i + ", ");
        }
        System.out.println("");
        for (Integer i : list) {
            System.out.println(i + ", ");
        }

    }
}
