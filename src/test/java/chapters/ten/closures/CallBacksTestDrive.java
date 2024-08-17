package chapters.ten.closures;

public class CallBacksTestDrive {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();

        MyIncrement.staticIncrement(callee2);

        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getCallBackReference());

        caller1.go();
        caller1.go();
        System.out.println("");
        caller2.go();
        caller2.go();

    }
}
