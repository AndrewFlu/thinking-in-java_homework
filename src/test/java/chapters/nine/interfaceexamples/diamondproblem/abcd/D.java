package chapters.nine.interfaceexamples.diamondproblem.abcd;

public class D implements IB, IC{
    @Override
    public void getClassName() {
        System.out.println("D");
    }
}
