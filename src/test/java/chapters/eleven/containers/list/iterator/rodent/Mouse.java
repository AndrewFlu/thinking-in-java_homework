package chapters.eleven.containers.list.iterator.rodent;

public class Mouse extends Rodent {

    public Mouse(Pool pool) {
        super(pool);
        System.out.println("Mouse()");
    }

    @Override
    protected void run() {
        System.out.println("Бежать отрывисто и хаотично");
    }

    @Override
    protected void eat() {
        System.out.println("Есть пшеницу");
    }
}
