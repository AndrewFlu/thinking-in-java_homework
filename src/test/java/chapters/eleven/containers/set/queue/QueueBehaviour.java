package chapters.eleven.containers.set.queue;

import utils.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueBehaviour {
    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> generator) {
        for (int i = 0; i < count; i++) {
            // insert an element, if capacity allow it
            queue.offer(generator.next());
        }

        System.out.println(queue.getClass().getSimpleName() + ": ");
        // retrieves, but does not remove an element
        while (queue.peek() != null) {
            // retrieves and removes an element from head of the queue
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    static class Gen implements Generator<String> {
        String[] sArray = ("one two three four five six seven " +
                "eight nine ten").split("\\s");
        int i;


        @Override
        public String next() {
            return sArray[i++];
        }
    }

    // test-drive
    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue<>(count), new Gen());
        test(new ConcurrentLinkedQueue<>(), new Gen());
        test(new LinkedBlockingQueue<>(), new Gen());
        test(new PriorityBlockingQueue<>(), new Gen());
    }
}
