package chapters.twenty_one.concurrency.threadlocal;

class Accessor implements Runnable {

    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && ThreadLocalVariableHolder.get() < 10) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
