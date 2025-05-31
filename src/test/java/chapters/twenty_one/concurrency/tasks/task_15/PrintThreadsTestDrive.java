package chapters.twenty_one.concurrency.tasks.task_15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintThreadsTestDrive {
    public static void main(String[] args) {
        PrintUtilities pu = new PrintUtilities();
        Printer printer = new Printer(25);
//        pu.printDocs(new Printer(4));

//        new Thread(){
//            @Override
//            public void run() {
//                pu.printDocs(printer);
//            }
//        }.start();
//
//        new Thread() {
//            @Override
//            public void run() {
//                pu.printNotes(printer);
//            }
//        }.start();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> pu.printNotes(printer));
        exec.execute(() -> pu.printImages(printer));
        exec.shutdown();
        pu.printDocs(printer);


    }
}
