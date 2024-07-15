package chapters.three;

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



    }
}
