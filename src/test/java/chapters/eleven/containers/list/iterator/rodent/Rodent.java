package chapters.eleven.containers.list.iterator.rodent;

public class Rodent {
    protected Pool pool;

    public Rodent(Pool pool) {
        System.out.println("Rodent()");
        this.pool = pool;
        this.pool.addReferenceCount();
    }

    protected void run() {
        System.out.println("Бежать");
    }

    protected void eat() {
        System.out.println("Есть");
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    protected void dispose() {
        this.pool.dispose();
    }
    public String toString() {
        return getClass().getSimpleName();
    }
}
