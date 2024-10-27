package chapters.fifteen.generics.sets;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    @SuppressWarnings("unchecked")
    private static <E> Set<E> cloneSet(Set<E> set) {
        Set<E> result;
        if (set instanceof EnumSet) {
            result = ((EnumSet) set).clone();
        } else {
            result = new HashSet<>(set);
        }

        return result;
    }

    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = cloneSet(a);
        result.addAll(b);

        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result;
        result = cloneSet(a);
        result.retainAll(b);

        return result;
    }

    // вычитание подмножества из надмножества
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {

        Set<T> result;
        result = cloneSet(a);
        result.removeAll(b);

        return result;
    }

    // уникальность (рефлексивность) — всё, что не входит в пересечение множеств
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
