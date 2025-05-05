package chapters.twenty_one.concurrency.joining;

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Joiner thread has been interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
