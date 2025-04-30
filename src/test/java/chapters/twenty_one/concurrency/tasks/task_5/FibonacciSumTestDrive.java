package chapters.twenty_one.concurrency.tasks.task_5;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciSumTestDrive {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new FibonacciSum(i)));
        }

        executorService.shutdown();

        for (Future<Integer> fi : results) {
            try {
                System.out.println(fi.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            }
        }
    }
}
