package chapters.twenty_one.concurrency.catching_exceptions.handled;

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("exceptionHandler = " + t.getUncaughtExceptionHandler());

        throw new RuntimeException();
    }
}
