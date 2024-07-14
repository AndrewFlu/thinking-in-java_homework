package chapters.three;

import static net.midview.Print.print;

public class Binary {
    public static void main(String[] args) {
        long decimal = 123456789;
        long hex = 0x75BCD15;
        long octal = 0726746425;

        print(String.format("Число %s в бинарном виде = %s", decimal, Long.toBinaryString(decimal)));
        print(String.format("16-ричное число %s в бинарном виде = %s", hex, Long.toBinaryString(hex)));
        print(String.format("8-ричное число %s в бинарном виде = %s", octal, Long.toBinaryString(octal)));
        print("Все числа равены между собой: " + (decimal == hex && hex == octal));
    }
}
