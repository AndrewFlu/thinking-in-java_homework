package chapters.ten.closures;

public class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println("Callee 1 i = " + i);
    }
}
