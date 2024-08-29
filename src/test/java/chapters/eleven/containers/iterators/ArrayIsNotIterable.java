package chapters.eleven.containers.iterators;

import java.util.Arrays;

public class ArrayIsNotIterable {
    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));

        String[] strings = {"A", "B", "C"};
        // массив работает в foreach, но не является Iterable
//        test(strings);
        // его нужно явно преобразовать в Iterable
        test(Arrays.asList(strings));
    }

    private static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.println(t + " ");
        }
    }
}
