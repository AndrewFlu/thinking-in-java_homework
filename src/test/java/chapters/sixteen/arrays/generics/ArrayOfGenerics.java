package chapters.sixteen.arrays.generics;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] listOfStrings;
        List[] listArray = new List[10];

        listOfStrings = (List<String>[])listArray; // неконтролируемое предупреждение
        listOfStrings[0] = new ArrayList<String>();
//        listOfStrings[1] = new ArrayList<Integer>(); // ошибка времени компиляции

        // проблема: List<String> является подтипом Object
        Object[] objects = listOfStrings; // значит, присваивание допустимо
        // Компилируется и выполняется без ошибок
        objects[1] = new ArrayList<Integer>();

        // Однако при простейших потребностях можно создать массив обобщений,
        // хотя и с неконтролируемым предупреждением:
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<BerylliumSphere>();
        }

        System.out.println(Arrays.toString(spheres));
    }
}
