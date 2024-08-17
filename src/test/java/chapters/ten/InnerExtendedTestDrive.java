package chapters.ten;

public class InnerExtendedTestDrive {
    public static void main(String[] args) {
        OuterWithInnerWithArgs outer = new OuterWithInnerWithArgs();
        SecondOuterWithInner.SecondInner secondInner = new SecondOuterWithInner().new SecondInner(new OuterWithInnerWithArgs(), "inheritance inner label");
    }
}
