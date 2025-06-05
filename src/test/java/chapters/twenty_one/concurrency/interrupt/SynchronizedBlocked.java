package chapters.twenty_one.concurrency.interrupt;

import static net.mindview.utils.Print.print;

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) // блокировка никогда не снимается
            Thread.yield();
    }

    public SynchronizedBlocked() {
        new Thread(){
            @Override
            public void run() {
                f(); // блокировка устанавливается этим потоком
            }
        }.start();
    }

    @Override
    public void run() {
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run");
    }
}
