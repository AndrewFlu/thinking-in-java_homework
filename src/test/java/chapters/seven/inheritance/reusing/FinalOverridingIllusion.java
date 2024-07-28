package chapters.seven.inheritance.reusing;

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

        // upcasting
        OverridingPrivate op1 = op2;
// !       op1.f();
// !       op1.g();
        WithFinals wf = op2;
// !       wf.f();
// !       wf.g();
    }
}
