package chapters.twenty_one.concurrency.interrupt.by_mutex;

import static net.mindview.utils.Print.print;

// Поток может многократно захватывать одну блокировку
public class MultiLock {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            print("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    private synchronized void f2(int count) {
        if (count-- > 0) {
            print("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        // todo: зачем здесь final?
        final MultiLock multiLock = new MultiLock();
        new Thread(){
            @Override
            public void run() {
                multiLock.f1(10);
            }
        }.start();
    }

}
