package chapters.ten;

public class SecondOuterWithInner {
    public class SecondInner extends OuterWithInnerWithArgs.InnerWithArgs{

        public SecondInner(OuterWithInnerWithArgs outer, String label) {
            outer.super(label);
        }
    }
}
