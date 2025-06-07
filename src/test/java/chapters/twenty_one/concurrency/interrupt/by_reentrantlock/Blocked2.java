package chapters.twenty_one.concurrency.interrupt.by_reentrantlock;

import static net.mindview.utils.Print.print;

public class Blocked2 implements Runnable {

    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        print("Waiting for f() in BlockedMutex()");
        blockedMutex.f();
        print("Broken out of blocked call");
    }
}
