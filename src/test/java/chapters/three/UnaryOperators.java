package chapters.three;

import static chapters.three.Hexademical.*;
import static net.midview.Print.print;

public class UnaryOperators {
    public static int ONE = 1;
    public static int TWO = 2;
    public static int THREE = 3;
    public static int FORE = 4;
    public static int FIVE = 5;
    public static int SIX = 6;
    public static int SEVEN = 7;
    public static int EIGHT = 8;
    public static int NINE = 9;
    public static int TEN = 10;


    public static void main(String[] args) {
        print("One in binary is " + Integer.toBinaryString(ONE));
        print("Two in binary is " + Integer.toBinaryString(TWO));
        print("Three in binary is " + Integer.toBinaryString(THREE));
        print("Fore in binary is " + Integer.toBinaryString(FORE));
        print("Five in binary is " + Integer.toBinaryString(FIVE));
        print("Six in binary is " + Integer.toBinaryString(SIX));
        print("Seven in binary is " + Integer.toBinaryString(SEVEN));
        print("Eight in binary is " + Integer.toBinaryString(EIGHT));
        print("Nine in binary is " + Integer.toBinaryString(NINE));
        print("Ten in binary is " + Integer.toBinaryString(TEN));
        print("");
        print("Коньюнкция [&] (И — поразрядное умножение):");
        System.out.printf("%s & %s is %s %n", ONE, TWO, Integer.toBinaryString(ONE & TWO));
        System.out.printf("%s & %s is %s %n", NINE, TEN, Integer.toBinaryString(NINE & TEN));
        print("");
        print("Дезьюнкция [|] (ИЛИ — поразрядное сложение)");
        System.out.printf("%s | %s is %s %n", NINE, TEN, Integer.toBinaryString(NINE | TEN));
        System.out.printf("%s | %s is %s %n", SIX, SEVEN, Integer.toBinaryString(SIX | SEVEN));
        print("");
        print("Исключающее ИЛИ [^]");
        System.out.printf("%s ^ %s is %s %n", EIGHT, NINE, Integer.toBinaryString(EIGHT ^ NINE));
        System.out.printf("%s ^ %s is %s %n", TWO, TEN, Integer.toBinaryString(TWO ^ TEN));
        print("");
        print("Поразрядное отрицание [~] (инверсия)");
        System.out.printf("~%s is %s in binary and is %s in decimal%n", TWO, Integer.toBinaryString(~TWO), ~TWO);
        System.out.printf("~%s is %s in binary and is %s in decimal%n", TEN, Integer.toBinaryString(~TEN), ~TEN);
        print("");
        print(LOW.toString());
        print(HIGH.toString());
        print("");
        print(HEX_A.toString());
        print(HEX_F.toString());
        print(HEX_0.toString());
        print(HEX_1.toString());
        print(HEX_7.toString());
        print("Домашнее задание");
        print("Коньюнкция [&] (И — поразрядное умножение):");
        int resultCon = LOW.getValue() & HIGH.getValue();
        print(String.format("%s & %s = %s. Decimal: %s", LOW.getLiteral(), HIGH.getLiteral(), Integer.toBinaryString(resultCon), resultCon));
        print("Дезьюнкция [|] (ИЛИ — поразрядное сложение)");
        int resultDes = LOW.getValue() | HIGH.getValue();
        print(String.format("%s | %s = %s. Decimal: %s", LOW.getLiteral(), HIGH.getLiteral(), Integer.toBinaryString(resultDes), resultDes));
        print("Исключающее ИЛИ [^]");
        int resultXor = LOW.getValue() ^ HIGH.getValue();
        print(String.format("%s ^ %s = %s. Decimal: %s", LOW.getLiteral(), HIGH.getLiteral(), Integer.toBinaryString(resultXor), resultXor));
        print("Поразрядное отрицание [~] (инверсия)");
        int lowInversion = ~LOW.getValue();
        print(String.format("~%s = %s. Decimal: %s", LOW.getLiteral(), Integer.toBinaryString(lowInversion), lowInversion));
        int highInversion = ~HIGH.getValue();
        print(String.format("~%s = %s. Decimal: %s", HIGH.getLiteral(), Integer.toBinaryString(highInversion), highInversion));

    }
}

enum Hexademical {
    LOW(0x0001, "0x0001"),
    HIGH(0x1000, "0x1000"),
    HEX_0(0x0000, "0x0000"),
    HEX_1(0x1111, "0x1111"),
    HEX_7(0x7777, "0x7777"),
    HEX_A(0xaaaa, "0xaaaa"),
    HEX_F(0xffff, "0xffff");

    Hexademical(int value, String literal) {
        this.value = value;
        this.literal = literal;
    }

    private final int value;
    private final String literal;

    public int getValue() {
        return value;
    }

    public String getLiteral() {
        return literal;
    }

    @Override
    public String toString() {
        return String.format("%s is %s in binary and is %s in decimal", this.getLiteral(), Integer.toBinaryString(this.getValue()), this.getValue());
    }
}