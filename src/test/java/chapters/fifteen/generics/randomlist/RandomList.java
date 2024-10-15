package chapters.fifteen.generics.randomlist;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private final ArrayList<T> storage = new ArrayList<T>();
    private final Random random = new Random();

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    // test-drive
    public static void main(String[] args) {
        RandomList<String> rls = new RandomList<>();
        for (String s : ("The quick brown fox jumped over the lazy brown dog".split("\\s"))) {
            rls.add(s);
        }

        for (int i = 0; i < 15; i++) {
            System.out.print(rls.select() + " ");
        }
    }
}
