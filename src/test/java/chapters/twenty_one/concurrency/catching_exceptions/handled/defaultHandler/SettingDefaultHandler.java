package chapters.twenty_one.concurrency.catching_exceptions.handled.defaultHandler;


import chapters.twenty_one.concurrency.catching_exceptions.handled.MyUncaughtExceptionHandler;
import chapters.twenty_one.concurrency.catching_exceptions.unhandled.ExceptionThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new ExceptionThread());
    }
}
