package chapters.eight.rodent;

public class Hamster extends Rodent {

    public Hamster() {
        System.out.println("Hamster()");
    }

    @Override
    protected void run() {
        System.out.println("Бежать в колесе");
    }

    @Override
    protected void eat() {
        System.out.println("Грызть одежду");;
    }
}
