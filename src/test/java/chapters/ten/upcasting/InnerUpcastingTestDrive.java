package chapters.ten.upcasting;

import chapters.ten.upcasting.children.ChildFunction;
import chapters.ten.upcasting.classes.Function;

public class InnerUpcastingTestDrive {
    public static void main(String[] args) {
        ChildFunction child = new ChildFunction();

        Function function = new Function();
        function.fetInnerFunctionalClass().printSingleMethodName();
    }
}
