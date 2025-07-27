package chapters.twenty_one.concurrency.read_write_lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;
    // Make the ordering fair:
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterList(int size, T initialValue) {
        lockedList = new ArrayList<>(Collections.nCopies(size, initialValue));
    }

    public T set(int index, T element) {
        Lock wlock = lock.writeLock();
        wlock.lock();
        try {
            return lockedList.set(index, element);
        } finally {
            wlock.unlock();
        }
    }

    public T get(int index) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            // показать, что блокировка может быть получена
            // несколькими задачами чтения:
            if (lock.getReadLockCount() > 1)
                System.out.println(lock.getReadLockCount());
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReaderWriterListTest(30, 1);
    }
}

class ReaderWriterListTest {
    ExecutorService exec = Executors.newCachedThreadPool();
    private static final int SIZE = 100;
    private static Random rand = new Random(47);
    private ReaderWriterList<Integer> list = new ReaderWriterList<>(SIZE, 0);

    public ReaderWriterListTest(int readers, int writers) {
        for (int i = 0; i < readers; i++) {
            exec.execute(new Reader());
        }
        for (int i = 0; i < writers; i++) {
            exec.execute(new Writer());
        }
    }

    private class Writer implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < 20; i++) { // 2-секундный тест
                        list.set(i, rand.nextInt());
                        TimeUnit.MILLISECONDS.sleep(100);

                    }
                }
            } catch (InterruptedException ignore) {
                // Допустимый способ выхода
            }
            System.out.println("Writing finished, shutting down");
            exec.shutdownNow();
        }
    }

    private class Reader implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException ignore) {
                // Допустимый способ выхода
            }
        }
    }
}
