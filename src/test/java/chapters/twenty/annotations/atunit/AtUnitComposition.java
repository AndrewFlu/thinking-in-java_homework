package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class AtUnitComposition {
    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return testObject.method1().equals("This is method 1");
    }

    @Test
    boolean _methodTwo() {
        return testObject.method2() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.AtUnitComposition");
    }
}
