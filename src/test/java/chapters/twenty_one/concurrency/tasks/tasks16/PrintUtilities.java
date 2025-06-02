package chapters.twenty_one.concurrency.tasks.tasks16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintUtilities {

    public static final int PRINT_COUNT = 10;

    public void printDocs(Printer printer) {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            for (int i = 0; i < PRINT_COUNT; i++) {
                if (printer.canPrint()) {
                    System.out.println("Printing docs...");
                    printer.actualInkQauntity--;
                    Thread.yield();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printNotes(Printer printer) {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            for (int i = 0; i < PRINT_COUNT; i++) {
                if (printer.canPrint()) {
                    System.out.println("Printing notes...");
                    printer.actualInkQauntity--;
                    Thread.yield();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printImages(Printer printer) {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            for (int i = 0; i < PRINT_COUNT; i++) {
                if (printer.canPrint()) {
                    System.out.println("Printing images...");
                    printer.actualInkQauntity--;
                    Thread.yield();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
