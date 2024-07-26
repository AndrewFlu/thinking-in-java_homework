package chapters.seven.inheritance.argsconstructor;

public class ChildOfBaseArgs extends BaseArgs {
    private static final int I = 10;

    public ChildOfBaseArgs() {
        super(I);
        System.out.println("ChildOfBaseArgs()");

    }

    public ChildOfBaseArgs(int i) {
        super(i);
        System.out.println("ChildOfBaseArgs(int i)");
    }

    public static void main(String[] args) {
        ChildOfBaseArgs c = new ChildOfBaseArgs();
        System.out.println(c.i);
        ChildOfBaseArgs x = new ChildOfBaseArgs(5);
        System.out.println(x.i);

    }
}
