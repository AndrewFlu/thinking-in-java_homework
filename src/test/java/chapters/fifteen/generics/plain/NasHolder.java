package chapters.fifteen.generics.plain;

public class NasHolder<T> {
    private T one;
    private T two;
    private T three;

    public NasHolder(T one, T two, T three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public T getOne() {
        return one;
    }

    public void setOne(T one) {
        this.one = one;
    }

    public T getTwo() {
        return two;
    }

    public void setTwo(T two) {
        this.two = two;
    }

    public T getThree() {
        return three;
    }

    public void setThree(T three) {
        this.three = three;
    }

    public static class Disc {
        private final int capacity;
        private final String brand;

        public Disc(int capacity, String brand) {
            this.capacity = capacity;
            this.brand = brand;
        }

        @Override
        public String toString() {
            return "Disc: " + brand +
                    " with capacity = " + capacity + " Gb";
        }
    }
}
