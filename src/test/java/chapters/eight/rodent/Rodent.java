package chapters.eight.rodent;

public class Rodent {
    protected void run() {
        System.out.println("Бежать");
    }

    protected void eat() {
        System.out.println("Есть");
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
