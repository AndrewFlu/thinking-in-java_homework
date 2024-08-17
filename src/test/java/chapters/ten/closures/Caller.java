package chapters.ten.closures;

public class Caller {
    private Incrementable callBackReference;

    public Caller(Incrementable callBackReference) {
        this.callBackReference = callBackReference;
    }

    void go() {
        callBackReference.increment();
    }
}
