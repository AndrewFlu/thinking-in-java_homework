package chapters.twenty.annotations.apt;

import com.sun.xml.internal.rngom.ast.builder.Div;

@ExtractInterface("IDivider")
public class Divider {
    public int divide(int x, int y) {
        if (y == 0)
            throw new ArithmeticException("Cannot divide to zero");
        int diff = subtract(x, y);
        if (diff < 0)
            return 0;
        if (diff == 0)
            return 1;
        int result = 0;
        while (diff >= 0 ){
            result++;
            diff = subtract(diff, y);
        }

        return result;
    }

    private int subtract(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        Divider d = new Divider();
        try {
            System.out.println("10 / 5 = " + d.divide(10, 5));
            System.out.println("10 / 10 = " + d.divide(10, 10));
            System.out.println("10 / 1 = " + d.divide(10, 1));
            System.out.println("10 / 20 = " + d.divide(10, 20));
            System.out.println("10 / 0 = " + d.divide(10, 0));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
