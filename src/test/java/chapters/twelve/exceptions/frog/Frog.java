package chapters.twelve.exceptions.frog;

public class Frog extends Amphibian {

    public void go() {
        System.out.println("Прыгать");
        throw new RuntimeException("Лёд");
    }

    public void swim() {
        System.out.println("Плыть по-лягушачьи");
    }

    public void dry() {
        super.dry();
        System.out.println("Посидеть на солнышке");
    }

    public static void main(String[] args) {
        Frog frog = new Frog();

        Amphibian amphibian = frog;
        try {
        amphibian.go();
        amphibian.swim();
        } catch (RuntimeException ex) {
            ex.printStackTrace(System.out);
        } finally {
            frog.dry();
        }
    }
}
