package chapters.twenty_one.concurrency.catching_exceptions.handled;

import java.util.concurrent.ThreadFactory;

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("exceptionHandler = " + t.getUncaughtExceptionHandler());

        return t;
    }
}
