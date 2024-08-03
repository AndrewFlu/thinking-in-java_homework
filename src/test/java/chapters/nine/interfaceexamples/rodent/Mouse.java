package chapters.nine.interfaceexamples.rodent;

public class Mouse implements Rodent {

    @Override
    public void run() {
        System.out.println("Бежать отрывисто и хаотично");
    }

    @Override
    public void eat() {
        System.out.println("Есть пшеницу");
    }

    @Override
    public String toString() {
        return getName();
    }
}
