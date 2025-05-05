package chapters.twenty_one.concurrency.joining;

public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Засоня", 1500),
                lark = new Sleeper("Жаворонок", 1500);
        Joiner
                reveler = new Joiner("Гуляка", sleepy),
                freeloader = new Joiner("Халявщик", lark);

        lark.interrupt();
    }
}
