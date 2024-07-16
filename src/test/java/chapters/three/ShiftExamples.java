package chapters.three;

import static net.midview.Print.print;

public class ShiftExamples {
    private static final int HIGH = 0xffff;
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        print(String.format("HIGH in decimal = %s, in binary = %s", HIGH, Integer.toBinaryString(HIGH)));
        print(String.format("MAX in decimal = %s, in binary = %s", MAX, Integer.toBinaryString(MAX)));
        print("");
        int min = 0b1000_0000_0000_0000_0000_0000_0000_0000;
        print(String.valueOf(min));
        print("");
        for (int i = 0; i < 32; i++) {
            System.out.printf("MAX >> %s = %s%n", i, Integer.toBinaryString(MAX >> i));
        }
    }
}
