package chapters.nine.abstractexamples.printer;

public class PrinterTestDrive {
    public static void main(String[] args) {
        AbstractPrinter hp = new HpPrinter();
        hp.print();
    }
}
