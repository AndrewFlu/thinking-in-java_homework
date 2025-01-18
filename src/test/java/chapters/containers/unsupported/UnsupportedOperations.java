package chapters.containers.unsupported;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class UnsupportedOperations {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 5);
        // копирование подсписка
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }

        try {
            c.add("B");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }

        try {
            c.remove("D");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }

        try {
            list.replaceAll(String::toLowerCase);
        } catch (Exception e) {
            System.out.println("List.replaceAll(): " + e);
        }

        // метод List.set() изменяет значение, но не изменяет размер структуры данных
        try {
            list.set(1, "X");
        } catch (Exception e) {
            System.out.println("list.set(): " + e);
        }
    }

    public static void main(String[] args) {
        String[] stringArray = "A B C D E F G H I J K L M N O P Q R S T U V W X U Z".split("\\s");
        List<String> list = Arrays.asList(stringArray);
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("Unmodifiable List", Collections.unmodifiableList(new ArrayList<>(list)));
        test("List.of()", List.of(stringArray));
    }
}
