package chapters.sixteen.arrays.generics;

import chapters.sixteen.arrays.containercomparison.BerylliumSphere;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<List<String>> listOfStrings = new ArrayList<>();
//        List[] listArray = new List[10];

//        listOfStrings = listArray; // неконтролируемое предупреждение
        listOfStrings.add(new ArrayList<String>());

        System.out.println(listOfStrings);
        System.out.println();
//        listOfStrings[1] = new ArrayList<Integer>(); // ошибка времени компиляции

        // проблема: List<String> является подтипом Object
//        Object[] objects = listOfStrings; // значит, присваивание допустимо
        // Компилируется и выполняется без ошибок
//        objects[1] = new ArrayList<Integer>();

        // Однако при простейших потребностях можно создать массив обобщений,
        // хотя и с неконтролируемым предупреждением:
        List<List<BerylliumSphere>> spheres = new ArrayList<>(10);
        spheres.add(new ArrayList<>(2));
        spheres.add(new ArrayList<>(3));
        spheres.add(new ArrayList<>(List.of(new BerylliumSphere(), new BerylliumSphere())));

        System.out.println(spheres);
    }
}
