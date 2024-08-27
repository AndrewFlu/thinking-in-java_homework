package chapters.eleven.containers.queue.command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CommandController {
    public static Queue<Command> constructQueue(int capacity) {
        Queue<Command> queue = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            queue.offer(getRandomCommand());
        }

        return queue;
    }

    private static Command getRandomCommand() {
        Random random = new Random();

        int nextInt = random.nextInt(3);
        return switch (nextInt) {
            case 0 -> new Command("Zero command");
            case 1 -> new Command("First command");
            case 2 -> new Command("Second command");
            default -> throw new IllegalStateException("Unexpected value: " + nextInt);
        };
    }

    private static void printQ(Queue<Command> queue) {
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
    }
}
