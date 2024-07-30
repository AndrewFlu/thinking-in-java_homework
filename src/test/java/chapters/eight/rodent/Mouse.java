package chapters.eight.rodent;

public class Mouse extends Rodent {
    @Override
    protected void run() {
        System.out.println("Бежать отрывисто и хаотично");
    }

    @Override
    protected void eat() {
        System.out.println("Есть пшеницу");
    }
}
