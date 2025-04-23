package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class Task5Test extends Task5 {

    @Test
    boolean _methodOneTes() {
        return methodOne().equals("This is method 1");
    }

    @Test
    boolean _methodTwoTest() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.AtUnitExample4");
    }
}
