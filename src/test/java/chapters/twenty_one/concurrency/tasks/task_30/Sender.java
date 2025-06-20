package chapters.twenty_one.concurrency.tasks.task_30;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    private Random random = new Random(47);
    private BlockingQueue<Character> pipe = new LinkedBlockingQueue<>();

    public BlockingQueue<Character> getPipe() {
        return pipe;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    pipe.put(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Sender sleep interrupted: " + e);
        }
    }
}
