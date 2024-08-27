package chapters.eleven.containers.queue.command;

import java.util.Queue;

public class CommandTestDrive {
    public static void main(String[] args) {
        Queue<Command> commands = CommandController.constructQueue(7);

        while(commands.peek() != null) {
            commands.remove().operation();
        }
    }
}
