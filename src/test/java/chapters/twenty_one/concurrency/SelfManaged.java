package chapters.twenty_one.concurrency;

public class SelfManaged implements Runnable {
    private int countdown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    public String toString() {
        return Thread.currentThread().getName() + "(" + countdown + ")";
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
            new SelfManaged();
        }
    }
}
