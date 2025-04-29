package chapters.twenty_one.concurrency.tasks;

public class Task1 implements Runnable {
    private static int counter = 0;
    private final int id = counter++;

    public Task1() {
        System.out.println("Message into constructor. " + this);
    }

    public String toString() {
        return "Object [Task1]: #" + id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("#" + i + " message into run(). " + this);
            Thread.yield();
        }

        System.out.println(this + " done job!");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task1()).start();
        }
    }
}
