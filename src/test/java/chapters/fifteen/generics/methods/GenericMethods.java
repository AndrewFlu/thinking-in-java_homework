package chapters.fifteen.generics.methods;

public class GenericMethods {
    public <T, U, V> void func(T x, U y, V z) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.func("Hi", 10, 10.1);
    }
}
