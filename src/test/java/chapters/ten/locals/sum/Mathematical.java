package chapters.ten.locals.sum;

public class Mathematical {
    ISum sum() {
        class LocalSum implements ISum {

            @Override
            public int addition(int a, int b) {
                return a + b;
            }
        }

        return new LocalSum();
    }

    public static void main(String[] args) {
        Mathematical math = new Mathematical();
        ISum sum = math.sum();
        int i = 2;
        int j = 5;
        System.out.println(String.format("%s + %s = %s", i, j, sum.addition(i, j)));
        i = -5;
        j = 10;
        System.out.println(String.format("%s + %s = %s", i, j, sum.addition(i, j)));
    }
}
