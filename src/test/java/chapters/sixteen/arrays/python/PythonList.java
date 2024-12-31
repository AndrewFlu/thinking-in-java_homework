package chapters.sixteen.arrays.python;

import chapters.sixteen.arrays.generators.converttoprimitives.ConvertTo;

import java.util.Arrays;

public class PythonList {
    public static void main(String[] args) {
        int[] aList = {1, 2, 3, 4, 5};
        System.out.println("type: " + aList.getClass().getTypeName());
        System.out.println(Arrays.toString(aList));
        System.out.println(aList[4]);
        // добавить новый элемент
        int[] newList = new int[aList.length + 1];
        System.arraycopy(aList, 0 , newList, 0, aList.length);
        newList[newList.length - 1] = 6;
        System.out.println(Arrays.toString(newList));
        // добавить массив в массив
        int[] src = {7, 8};
        int[] dest = new int[newList.length + src.length];
        System.arraycopy(newList, 0, dest, 0, newList.length);
        System.arraycopy(src, 0 , dest, 6, src.length);
        System.out.println(Arrays.toString(dest));
        // выделить часть из массива
        int[] copy = Arrays.copyOfRange(dest, 2, 4);
        System.out.println(Arrays.toString(copy));

        MyList list2 = new MyList(aList);
        System.out.println("Integer[]: " + list2);
        System.out.println("type: " + list2.getClass().getTypeName());
        System.out.println("reversed: " + Arrays.toString(list2.getReversed()));
    }
}
