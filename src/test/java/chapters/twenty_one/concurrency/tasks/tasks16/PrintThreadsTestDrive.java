package chapters.twenty_one.concurrency.tasks.tasks16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintThreadsTestDrive {
    public static void main(String[] args) {
        PrintUtilities pu = new PrintUtilities();
        Printer printer = new Printer(4);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> pu.printNotes(new Printer(5)));
        exec.execute(() -> pu.printImages(new Printer(5)));
        exec.shutdown();
        pu.printDocs(printer);


    }
}
