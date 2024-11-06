package chapters.fifteen.generics.erasedtype.array;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Предоставляет нижележащее представление
    public T[] replicate() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(5);
//        Приводит к возбуждению ClassCastException
//        Integer[] replicated = gai.replicate();
        // А это допустимо
        Object[] replicated = gai.replicate();
    }
}
