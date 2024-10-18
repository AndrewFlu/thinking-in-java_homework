package chapters.fifteen.generics.methods;

public class GenericMethods {
    public <T, U>  void func(T x, U y, String s) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(s.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.func(1, 1.7, "Hi!");
    }
}
