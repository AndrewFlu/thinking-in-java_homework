package chapters.eleven.containers.list.iterator.rodent;

public class Hamster extends Rodent {

    public Hamster(Pool pool) {
        super(pool);
        System.out.println("Hamster()");
    }

    @Override
    protected void run() {
        System.out.println("Бежать в колесе");
    }

    @Override
    protected void eat() {
        System.out.println("Грызть одежду");
    }
}
