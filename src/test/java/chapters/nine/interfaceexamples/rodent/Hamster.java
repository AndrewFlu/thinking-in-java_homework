package chapters.nine.interfaceexamples.rodent;

public class Hamster implements Rodent {
    @Override
    public void run() {
        System.out.println("Бежать в колесе");
    }

    @Override
    public void eat() {
        System.out.println("Грызть одежду");
    }

    @Override
    public String toString() {
        return getName();
    }
}
