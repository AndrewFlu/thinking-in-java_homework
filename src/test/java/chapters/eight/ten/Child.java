package chapters.eight.ten;

public class Child extends Base {
    @Override
    protected void second() {
        System.out.println("overriding second method in the child");
    }

    public static void main(String[] args) {
        Child child = new Child();
        Base base = child;

        base.first();
    }
}
