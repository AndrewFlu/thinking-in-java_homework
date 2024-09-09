package chapters.thirteen.strings.formatspecificators;

import java.util.Formatter;

public class AllModificators {

    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        System.out.println("Пример использования форматных спецификаторов для целочисленного числа (%d):\n");
        formatter.format("[%-7d] — число 11 с выравниванием по левому краю, шириной в 7 символов", 11);
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для вещественного числа (%f):\n");
        formatter.format("[%10.3f] — число 7,123 с выравниванием по правому краю, с точностью в 3 символа, общей шириной в 10", 7.1234567);
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для вещественного числа в экспоненциальной записи (%e):\n");
        formatter.format("[%-30.15e] — число 50777.666_555 в экспоненциальной записи шириной в 30 символов с выравниванием по левому краю", 50777.666555);
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для строки (%s):\n");
        formatter.format("[%-15.10s] — строка 'MacBook Pro M1', шириной в 15 символов, но местом под вывод в 10 ячеек", "MacBook Pro M" + (0 + 1));
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для логических значений (%b):\n");
        formatter.format("[%5b] — булево для 0", 0);
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для символов юникода (%с):\n");
        char character = 'a';
        formatter.format("[%-5c] – 'a'", character);
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для шестнадцатеричных значений (%x):\n");
        formatter.format("[%-7x] — число 1024 в 16-ном пердставлении", 1024);
        System.out.println();

        System.out.println("Пример использования форматных спецификаторов для значений хеш-кода (%h):\n");
        formatter.format("[%-16h] — хэш для слова Bitcoin", "Bitcoin");
        System.out.println();
    }
}
