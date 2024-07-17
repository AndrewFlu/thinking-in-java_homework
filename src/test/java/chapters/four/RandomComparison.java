package chapters.four;

import java.util.Random;

public class RandomComparison {
    private static final int MAX_COUNT = 25;

    public static void main(String[] args) {
        for (int i = 0; i < MAX_COUNT; i++) {
            int a = getRandomInt();
            int b = getRandomInt();
            printCompareResult(a, b);
        }
    }

    private static void printCompareResult(int a, int b) {
        if (a > b) {
            System.out.printf("%s > %s%n", a, b);
        } else if (a == b) {
            System.out.printf("%s == %s%n", a, b);
        } else {
            System.out.printf("%s < %s%n", a, b);
        }
    }

    private static int getRandomInt() {
        Random random = new Random();

        return random.nextInt(100);
    }
}
