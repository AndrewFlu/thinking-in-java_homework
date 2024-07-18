package chapters.four;

import static net.midview.Print.print;

public class TernaryBitwiseOperations {
    public static final int LOW = 0b0101_0101_0101_0101_0101_0101_0101_0101;
    public static final int HEX_LOW = 0x55555555;
    public static final int HIGH = 0b1010_1010_1010_1010_1010_1010_1010_1010;
    public static final int HEX_HIGH = 0xaaaaaaaa;

    public static void main(String[] args) {
        print(String.format("%s in binary — %s", LOW, Integer.toBinaryString(LOW)));
        print(String.format("%s in binary — %s", HEX_LOW, Integer.toBinaryString(HEX_LOW)));
        print(String.format("%s in binary — %s", HIGH, Integer.toBinaryString(HIGH)));
        print(String.format("%s in binary — %s", HEX_HIGH, Integer.toBinaryString(HEX_HIGH)));
    }
}
