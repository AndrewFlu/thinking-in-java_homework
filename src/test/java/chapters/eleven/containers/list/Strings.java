package chapters.eleven.containers.list;

import chapters.ten.anonymous.args.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strings {
    private static Random random = new Random();

    public static List<String> arrayList(int capacity) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(generateRandomWord());
        }

        return list;
    }

    private static String generateRandomWord() {
        StringBuilder builder = new StringBuilder();
        int i = random.nextInt(3, 5);
        for (int j = 0; j < i; j++) {
            builder.append((char)random.nextInt(70, 90));
        }

        return builder.toString();
    }
}
