package chapters.four;

import static net.mindview.utils.Print.print;

public class CheckBoundary {
    public static void main(String[] args) {
        System.out.println(test(10, 7));
        System.out.println(test(1, 5));
        System.out.println(test(7, 7));
        print("");
        System.out.println(checkBoundary(7, 5, 1, 6));
        System.out.println(checkBoundary(7, 5, 1, 7));
        System.out.println(checkBoundary(1, 3, 1, 7));
        System.out.println(checkBoundary(19, 10, 2, 97));
    }

    private static int checkBoundary(int testValue, int targetValue, int begin, int end) {
        if (testValue > targetValue && testValue >= begin && testValue <= end) {
            return +1;
        } else if (testValue == targetValue && testValue >= begin && testValue <= end) {
            return 0;
        } else {
            return -1;
        }
    }

    private static int test(int testValue, int targetValue) {
        if (testValue > targetValue) {
            return +1;
        } else if (testValue < targetValue) {
            return -1;
        } else {
            return 0;
        }
    }
}
