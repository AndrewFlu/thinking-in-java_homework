package chapters.twenty_one.concurrency.variants_of_implementation;

public class SimpleThread extends Thread {
    private int countdown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        // сохранение имени потока
        super(String.valueOf(++threadCount));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countdown + ")";
    }

    public void run() {
        while (true) {
            System.out.println(this);
            if (--countdown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
