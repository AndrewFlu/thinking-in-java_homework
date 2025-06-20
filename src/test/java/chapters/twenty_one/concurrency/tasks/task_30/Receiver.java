package chapters.twenty_one.concurrency.tasks.task_30;

import java.util.concurrent.BlockingQueue;

public class Receiver implements Runnable {

    private BlockingQueue<Character> pipeIn;

    public Receiver(Sender sender) {
        pipeIn = sender.getPipe();
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Блокируется до появления символов
                System.out.println("Read: " + pipeIn.take() + ", ");
            }
        } catch (InterruptedException e) {
            System.out.println("Receiver interrupted: " + e);
        }
    }
}
