package chapters.twenty_one.concurrency.tasks.task_15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintThreadsTestDrive {
    public static void main(String[] args) {
        PrintUtilities pu = new PrintUtilities();
        Printer printer = new Printer(2);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> pu.printNotes(new Printer(2)));
        exec.execute(() -> pu.printImages(new Printer(50)));
        exec.shutdown();
        pu.printDocs(printer);


    }
}
