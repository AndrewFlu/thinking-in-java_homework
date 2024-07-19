package chapters.four;

import static net.midview.Print.print;

public class VampireDigits {

    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            if (isVampire(i)) print(String.valueOf(i));
        }
    }

    private static boolean isVampire(int number) {
        if (number < 1000 || number >= 10000) {
            throw new IllegalArgumentException(String.format("Число %s не является четырёхзначным положительным числом", number));
        }
//        if (isLastSymbolIsZero(number)) {
//            return false;
//        }

        int first = number / 1000;
        int second = (number % 1000) / 100;
        int third = (number % 100) / 10;
        int fourth = number % 10;

        return concatTwoNumbers(first, second) * concatTwoNumbers(third, fourth) == number ||
                concatTwoNumbers(first, second) * concatTwoNumbers(fourth, third) == number ||

                concatTwoNumbers(second, first) * concatTwoNumbers(third, fourth) == number ||
                concatTwoNumbers(second, first) * concatTwoNumbers(fourth, third) == number ||

                concatTwoNumbers(first, third) * concatTwoNumbers(second, fourth) == number ||
                concatTwoNumbers(first, third) * concatTwoNumbers(fourth, second) == number ||

                concatTwoNumbers(third, first) * concatTwoNumbers(second, fourth) == number ||
                concatTwoNumbers(third, first) * concatTwoNumbers(fourth, second) == number ||

                concatTwoNumbers(first, fourth) * concatTwoNumbers(second, third) == number ||
                concatTwoNumbers(first, fourth) * concatTwoNumbers(third, second) == number ||

                concatTwoNumbers(fourth, first) * concatTwoNumbers(third, second) == number ||
                concatTwoNumbers(fourth, first) * concatTwoNumbers(second, third) == number
                ;
    }

    private static boolean isLastSymbolIsZero(int number) {
        String string = String.valueOf(number);
        char[] charArray = string.toCharArray();
        char lastChar = charArray[charArray.length - 1];
        int lastInt = Integer.parseInt(String.valueOf(lastChar));

        return lastInt == 0;
    }

    private static int concatTwoNumbers(int first, int second) {
        return Integer.parseInt("" + first + second);
    }
}