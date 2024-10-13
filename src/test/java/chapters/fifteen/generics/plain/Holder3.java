package chapters.fifteen.generics.plain;

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    // test drive
    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
        Automobile a = h3.getA();
//        h3.setA("String"); // ошибка: недопустимый тип
//        h3.setA(1); // ошибка: недопустимый тип
    }

}
