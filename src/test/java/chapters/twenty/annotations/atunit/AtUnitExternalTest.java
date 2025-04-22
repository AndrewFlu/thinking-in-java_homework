package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class AtUnitExternalTest  extends AtUnitExample1 {
    @Test
    boolean _methodOne() {
        return method1().equals("This is method 1");
    }

    @Test boolean _methodTwo() {
        return method2() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command("java /Users/andrey/Documents/dev/projects/thinking_In_java/TIJ4-homework/TIJ4-homework/src/test/java/chapters/twenty/annotations/atunit/AtUnitExternalTest.java");
    }
}
