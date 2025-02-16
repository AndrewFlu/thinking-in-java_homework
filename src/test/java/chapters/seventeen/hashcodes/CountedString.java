package chapters.seventeen.hashcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Example of creating proper hashCode by Effective Java (Joshua Bloch)
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char symbol;

    public CountedString(String s) {
        this.s = s;
        this.symbol = (s.isEmpty() ? 'X' : s.charAt(0));
        created.add(s);
        // id — общее количество экземпляров данной строки, используемых классом CountedString
        for (String str : created)
            if (str.equals(s))
                id++;
    }

    @Override
    public String toString() {
        return "String: " + s +
                ", id: " + id +
                ", firstSymbol: " + symbol +
                ", hashCode(): " + hashCode() +
                "; ";
    }

    @Override
    public int hashCode() {
        // Очень простая схема:
        // вернуть s.hashCode() * id
        // по рецепту Джошуа Блока
        int result = 17;
        result = 37 * result + s.hashCode();
//        result = 37 * result + id;
        result = 37 * result + (int)symbol;

        return result;
    }

    @Override
    public boolean equals(Object arg) {
        return arg instanceof CountedString &&
                s.equals(((CountedString) arg).s) &&
                id == ((CountedString) arg).id &&
                symbol == ((CountedString) arg).symbol;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);

        // Проблема: hashCode одинаковый для разных объектов
        for (CountedString cString : cs) {
            System.out.println("Look up " + cString);
            System.out.println(map.get(cString));
        }
    }
}
