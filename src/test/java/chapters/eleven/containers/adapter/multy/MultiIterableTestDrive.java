package chapters.eleven.containers.adapter.multy;

public class MultiIterableTestDrive {
    public static void main(String[] args) {
        MultiIterableClass multiIterable = new MultiIterableClass();

        for (String s : multiIterable.reversed()) {
            System.out.println(s + " ");
        }

        for (String s : multiIterable.randomized()) {
            System.out.println(s + " ");
        }

        for (String s : multiIterable) {
            System.out.println(s + " ");
        }
    }
}
