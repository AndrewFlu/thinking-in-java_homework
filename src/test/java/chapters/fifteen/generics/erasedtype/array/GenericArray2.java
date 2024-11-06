package chapters.fifteen.generics.erasedtype.array;

public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int size) {
        array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gia2 = new GenericArray2<>(5);
        for (int i = 0; i < 5; i++) {
            gia2.put(i, i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(gia2.get(i) + " ");
        }
        System.out.println();

        try {
            Integer[] rep = gia2.rep();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
