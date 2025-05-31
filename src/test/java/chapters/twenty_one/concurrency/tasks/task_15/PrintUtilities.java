package chapters.twenty_one.concurrency.tasks.task_15;

public class PrintUtilities {

    public static final int PRINT_COUNT = 10;

    public void printDocs(Printer printer) {
        synchronized (printer) {
            for (int i = 0; i < PRINT_COUNT; i++) {
                if (printer.canPrint()) {
                    System.out.println("Printing docs...");
                    printer.actualInkQauntity--;
                    Thread.yield();
                }
            }
        }
    }

    public void printNotes(Printer printer) {
        synchronized (printer) {
            for (int i = 0; i < PRINT_COUNT; i++) {
                if (printer.canPrint()) {
                    System.out.println("Printing notes...");
                    printer.actualInkQauntity--;
                    Thread.yield();
                }
            }
        }
    }

    public void printImages(Printer printer) {
        synchronized (printer) {
            for (int i = 0; i < PRINT_COUNT; i++) {
                if (printer.canPrint()) {
                    System.out.println("Printing images...");
                    printer.actualInkQauntity--;
                    Thread.yield();
                }
            }
        }
    }

}
