package chapters.four;

public class SimpleNumbersFinder {
    public static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        for (int i = 0; i < UPPER_BOUND; i++) {
            for (int j = 2; j <= i; j++) {
                int tail = i % j;
                if (tail == 0) {
                    if (i == j) {
                        System.out.printf("%s — простое число%n", i);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
