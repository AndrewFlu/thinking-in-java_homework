package chapters.three;

import javax.xml.transform.Source;

public class Binary {
    public static void main(String[] args) {
        long decimal = 123456789;
        long hex = 0x75BCD15;
        long octal = 0726746425;
        System.out.printf("Число %s в бинарном виде = %s%n", decimal, Long.toBinaryString(decimal));
        System.out.printf("16-ричное число %s в бинарном виде = %s%n", hex, Long.toBinaryString(hex));
        System.out.printf("8-ричное число %s в бинарном виде = %s%n", octal, Long.toBinaryString(octal));
        System.out.println("Все числа равены между собой: " + (decimal == hex && hex == octal) );
    }
}
