package chapters.eleven.containers.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ints {
    private static final Random random = new Random();

    public static List<Integer> arrayList(int capacity) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(random.nextInt(0, 50));
        }

        return list;
    }
}
