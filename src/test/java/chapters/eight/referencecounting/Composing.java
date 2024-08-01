package chapters.eight.referencecounting;

public class Composing {
    private static long counter = 0;

    private Shared shared;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Создаём " + this);
        this.shared = shared;
        this.shared.addReference();
    }

    protected void dispose() {
        System.out.println("Завершаем " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing " + id;
    }
}