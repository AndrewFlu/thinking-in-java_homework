package chapters.eleven.containers.set.settypes;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {
    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        // оппытка добавления дубликатов
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    private static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType.class);
        test(new LinkedHashSet<>(), HashType.class);
        test(new TreeSet<>(), TreeType.class);

        System.out.println();
        // следующие операции имеют скрытые проблемы
        test(new HashSet<>(), SetType.class); // использован класс без переопределения hashCode()
        test(new HashSet<>(), TreeType.class); // использован класс без переопределения hashCode()
        test(new LinkedHashSet<>(), SetType.class); // использован класс без определения comparable()
        test(new LinkedHashSet<>(), TreeType.class); // использован класс без переопределения hashCode()

        System.out.println();
        try {
            test(new TreeSet<>(), SetType.class); // использован класс без определения comparable()
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), HashType.class); // использован класс без определения comparable()
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
