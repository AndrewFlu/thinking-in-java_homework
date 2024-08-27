package chapters.eleven.containers.priorityqueue;

import java.util.PriorityQueue;
import java.util.Random;

import static chapters.eleven.containers.queue.QueueDemo.printQ;

public class PriorityQDouble {
    public static void main(String[] args) {
        Random random = new Random();

        PriorityQueue<Double> doublePq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            doublePq.offer(random.nextDouble(i + 10.0));
        }

        while (doublePq.peek() != null) {
            System.out.println(doublePq.poll());
        }
    }
}
