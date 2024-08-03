package chapters.nine.abstractexamples.rodent;

public class Hamster extends Rodent {

    @Override
    protected void run() {
        System.out.println("Бежать в колесе");
    }

    @Override
    protected void eat() {
        System.out.println("Грызть одежду");
    }
}
