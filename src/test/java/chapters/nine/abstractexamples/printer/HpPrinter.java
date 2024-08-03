package chapters.nine.abstractexamples.printer;

public class HpPrinter extends AbstractPrinter {
    private static int counter;
    private final int pageCount = 5;
    @Override
    void print() {
        System.out.printf("Печатает принтер HP: %s страниц%n", pageCount);
        System.out.printf("Экземпляр HpPrinter c id = %s%n", counter++);
    }
}
