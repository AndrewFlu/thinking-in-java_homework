package chapters.twenty_one.concurrency.semaphore;

public class Fat {
    private volatile double d; // Предотвращает оптимизацию
    private static int counter = 0;
    private final int id = counter++;

    public Fat() {
        // Затратная, прерываемая операция
        for (int i = 0; i < 10_000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    public String toString() {
        return "Fat id: " + id;
    }
}
