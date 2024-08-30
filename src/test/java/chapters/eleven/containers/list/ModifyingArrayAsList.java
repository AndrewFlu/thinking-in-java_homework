package chapters.eleven.containers.list;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ModifyingArrayAsList {
    public static void main(String[] args) {
        Random random = new Random();

        Integer[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Исходный массив До перемешивания:");
        System.out.println(Arrays.toString(integerArray));

        List<Integer> integerArrayPacked = new ArrayList<>(Arrays.asList(integerArray));
        Collections.shuffle(integerArrayPacked, random);

        System.out.println("Перемешанный список (обёртка):");
        System.out.println(integerArrayPacked);
        System.out.println("Исходный массив После перемешивания:");
        System.out.println(Arrays.toString(integerArray));

        List<Integer> integersNoPack = Arrays.asList(integerArray);
        Collections.shuffle(integersNoPack, random);

        System.out.println("Перемешанный список (без обёртки):");
        System.out.println(integersNoPack);

        System.out.println("Исходный массив после пермешивания (без обёртки):");
        System.out.println(Arrays.toString(integerArray));
    }
}
