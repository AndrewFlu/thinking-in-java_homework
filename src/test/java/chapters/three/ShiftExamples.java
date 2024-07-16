package chapters.three;

import static net.midview.Print.print;

public class ShiftExamples {
    private static final int HIGH = 0xffff;
    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;
    private static final int MIN_BINARY = 0b1000_0000_0000_0000_0000_0000_0000_0000;
    private static final int NEGATIVE_ONE = 0b1111_1111_1111_1111_1111_1111_1111_1111;

    public static void main(String[] args) {
        print(String.format("HIGH in decimal = %s, in binary = %s", HIGH, Integer.toBinaryString(HIGH)));
        print(String.format("MAX in decimal = %s, in binary = %s", MAX, Integer.toBinaryString(MAX)));
        print("");
        print(String.valueOf(MIN_BINARY));
        print(String.valueOf(MIN));
        print("Shift for positive number");
        for (int i = 0; i < 32; i++) {
            System.out.printf("MAX >> %s = %s%n", i, Integer.toBinaryString(MAX >> i));
        }
        print("");
        print("Shift for negative number");
        print(String.format("NEGATIVE_ONE in decimal = %s, in binary = %s", NEGATIVE_ONE, Integer.toBinaryString(NEGATIVE_ONE)));
        int result = NEGATIVE_ONE << 1;
        print(String.format("NEGATIVE_ONE << 1 in decimal = %s, in binary = %s", result, Integer.toBinaryString(result)));
        print("");
        for(int i = 0; i < 33; i++) {
            int shifted = result >>> i;
            System.out.printf("RESULT >>> %s = %s, in decimal = %s%n", i, Integer.toBinaryString(shifted), shifted);
        }
    }
}
