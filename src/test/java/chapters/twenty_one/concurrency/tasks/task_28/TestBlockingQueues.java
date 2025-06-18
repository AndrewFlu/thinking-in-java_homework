package chapters.twenty_one.concurrency.tasks.task_28;

import chapters.twenty_one.concurrency.runnable.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class TestBlockingQueues {

    static void getKey() {
        try {
            // Компенсация различий Windows/Linux в длине результата,
            // проиводимого клавишей Enter:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        LiftOffAdder adder = new LiftOffAdder(runner);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(runner);
        exec.execute(adder);

//        Thread t = new Thread(runner);
//        t.start();
//        for (int i = 0; i < 5; i++)
//            runner.add(new LiftOff(5));

        getKey("Press 'Enter' (" + msg + ")");
        System.out.println("Finished " + msg + " test");
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>()); // неограниченный размер
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3)); // фиксированный размер
        test("SynchronousQueue", new SynchronousQueue<LiftOff>()); // размер 1
    }
}
