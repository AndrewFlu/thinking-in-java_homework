package chapters.eleven.containers.queue.command;

public class Command {
    private String operationName;

    public Command(String operationName) {
        this.operationName = operationName;
    }

    public void operation() {
        System.out.println(operationName);
    }

}
