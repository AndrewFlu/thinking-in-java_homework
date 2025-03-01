package chapters.seventeen.containers;

public class IntContainer {
    private int size;
    private int[] array;

    public IntContainer(int size) {
        this.array = new int[size];
    }

    public void add(int i) {
        if (size == array.length) {
            int[] extendedArray = new int[array.length + array.length / 2];
            System.arraycopy(array, 0, extendedArray, 0, array.length);
        }
        array[size++] = i;
    }

    public int get(int i) {
        return array[i];
    }

    public int size() {
        return size;
    }
    public void set(int position, int element) {
        array[position] = element;
    }
}
