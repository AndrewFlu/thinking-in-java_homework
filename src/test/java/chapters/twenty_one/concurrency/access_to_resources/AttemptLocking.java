package chapters.twenty_one.concurrency.access_to_resources;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void lockWithoutWait() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void lockWithWait2Seconds() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.lockWithoutWait(); // true — блокировка доступна
        al.lockWithWait2Seconds(); // true — блокировка доступна

        // теперь создаём отдельную задачу для получения блокировки
        new Thread() {
            {setDaemon(true);}
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        // Пердоставляем возможность второй задаче
        Thread.yield();

        al.lockWithoutWait(); // может иногда выдавать false — т.к. блокировка уже может быть захваченной
        al.lockWithWait2Seconds(); // может иногда выдавать false — т.к. блокировка уже может быть захваченной
    }
}
