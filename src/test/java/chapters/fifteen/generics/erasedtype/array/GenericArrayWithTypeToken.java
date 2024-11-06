package chapters.fifteen.generics.erasedtype.array;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private final T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArrayWithTypeToken = new GenericArrayWithTypeToken<>(Integer.class, 7);
        genericArrayWithTypeToken.put(0, 111);
        // теперь работает
        Integer[] rep = genericArrayWithTypeToken.rep();
        System.out.println(rep[0]);

    }
}
