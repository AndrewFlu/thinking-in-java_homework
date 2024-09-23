package chapters.forteen.typeinfo.recursion;

import chapters.forteen.typeinfo.shapes.Triangle;

import static net.midview.Print.print;

public class RecursionTypeInfo {
    public static void main(String[] args) {
        printHierarchyInfo(Triangle.class);
    }

    private static void printHierarchyInfo(Class clazz) {
        System.out.printf("Класс [%s] имеет следующую иерархию: \n", clazz.getSimpleName());
        while (clazz != null) {
            print("Класс: " + clazz.getName());
            clazz = clazz.getSuperclass();
        }
    }
}
