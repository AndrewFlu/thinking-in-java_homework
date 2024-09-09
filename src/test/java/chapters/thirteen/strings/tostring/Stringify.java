package chapters.thirteen.strings.tostring;

public class Stringify {
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;

    public Stringify(int anInt, long aLong, float aFloat, double aDouble) {
        this.anInt = anInt;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
    }

    @Override
    public String toString() {
        return String.format("Объект типа Stringify: int = %d, long = %d, float = %.2f, double = %.2f",
                anInt,
                aLong,
                aFloat,
                aDouble
        );
    }

    public static void main(String[] args) {
        Stringify s = new Stringify(1, 10000001L, 15.15F, 123456.0987654321);
        System.out.println(s);
    }
}
