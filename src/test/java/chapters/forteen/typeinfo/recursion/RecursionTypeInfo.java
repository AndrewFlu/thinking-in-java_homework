package chapters.forteen.typeinfo.recursion;

import chapters.forteen.typeinfo.shapes.Triangle;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static net.midview.Print.print;

public class RecursionTypeInfo {
    public static void main(String[] args) {
        printHierarchyInfo(Triangle.class);
    }

    private static void printHierarchyInfo(Class clazz) {
        System.out.printf("Класс [%s] имеет следующую иерархию: \n", clazz.getSimpleName());
        while (clazz != null) {
            print("\tКласс: " + clazz.getName() + " ");
            if (clazz.getDeclaredFields().length > 0) {
                print("\tКласс: " + clazz.getName() + " имеет следующие поля:");
                List<String> collect = Arrays.stream(clazz.getDeclaredFields())
                        .map(Field::getName)
                        .toList();
                for (String s : collect) {
                    System.out.println("\t\t" + s);
                }
            }

            clazz = clazz.getSuperclass();
        }
    }
}
