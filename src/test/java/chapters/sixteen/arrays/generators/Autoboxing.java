package chapters.sixteen.arrays.generators;

public class Autoboxing {
    public static void main(String[] args) {
        int[] arr = new int[5];
//        Integer[] objectsArr = arr; // несовместимые типы
        Integer[] objectsArr = new Integer[5];
//        arr = objectsArr; // несовместимые типы
    }
}
