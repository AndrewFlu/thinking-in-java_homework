package chapters.twenty_one.concurrency.interrupt.by_reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.utils.Print.print;

// Прерывание задачи, заблокированной по ReentrantLock
public class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        // Немедленное получение блокировки для демонстрации
        // прерывания задач, заблокированных по reentrantLock
        lock.lock();
    }

    public void f() {
        try {
            // Никогда на будет доступен для второй задачи
            lock.lockInterruptibly(); // специальный вызов (захватывает поток, до тех пор, пока этот поток не будет прерван)
            print("Блокировка получена в f() [lock acquired in f()]");
        } catch (InterruptedException e) {
            print("Прервано из-за блокировки, полученной в f() [interrupted from lock acquisition in f()]");
        }
    }
}
