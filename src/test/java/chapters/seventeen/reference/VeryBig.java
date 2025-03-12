package chapters.seventeen.reference;

import chapters.ten.SecondOuterWithInner;

public class VeryBig {
    private static final int SIZE = 10_000;
    private long[] longArray = new long[SIZE];
    private String ident;

    public VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);
    }
}
