package chapters.fifteen.generics.methods;

public class GenericMethods {
    public <T> void func(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.func("Hi");
        gm.func(10);
        gm.func(10.5);
        gm.func(10.7f);

    }
}
