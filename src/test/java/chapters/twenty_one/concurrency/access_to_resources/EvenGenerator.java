package chapters.twenty_one.concurrency.access_to_resources;

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue; // Опасная точка
        ++currentEvenValue;

        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator(), 5);
    }
}
