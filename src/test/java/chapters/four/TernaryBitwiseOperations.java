package chapters.four;

import static net.mindview.utils.Print.print;

public class TernaryBitwiseOperations {
    public static final int LOW = 0b0101_0101_0101_0101_0101_0101_0101_0101;
    public static final int HEX_LOW = 0x55555555;
    public static final int HIGH = 0b1010_1010_1010_1010_1010_1010_1010_1010;
    public static final int HEX_HIGH = 0xaaaaaaaa;

    public static void main(String[] args) {
        print(String.format("%s | %s = %s in binary", HEX_LOW, HEX_HIGH, printResult(HEX_LOW | HEX_HIGH)));
        print(String.format("%s & %s = %s in binary", HEX_LOW, HEX_HIGH, printResult(HEX_LOW & HEX_HIGH)));
        print(String.format("%s ^ %s = %s in binary", HEX_LOW, HEX_HIGH, printResult(HEX_LOW ^ HEX_HIGH)));
        print(String.format("~ %s = %s in binary", HEX_LOW, printResult(~HEX_LOW)));
        print(String.format("~ %s = %s in binary", HEX_HIGH, printResult(~HEX_HIGH)));
    }

    private static String printResult(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 31; j >= 0; j--){
            int i1 = i << j;
            int i2 = i1 >>> 31;
            char ch = i2 == 1 ? '1' : '0';
            stringBuilder.append(ch);
        }

        return stringBuilder.reverse().toString();
    }
}
