package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class AtUnitExample1 {
    public String method1() {
        return "This is method 1";
    }

    public int method2() {
        System.out.println("This is method 2");
        return 2;
    }

    @Test
    boolean methodOneTest() {
        return method1().equals("This is method 1");
    }

    @Test
    boolean m2() {
        return method2() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }

    @Test
    boolean failureTest() {
        return false;
    }

    @Test
    boolean anotherDisappointment() {
        return false;
    }

    public static void main(String[] args) {
        OSExecute.command("java src/test/java/chapters/twenty/annotations/atunit/AtUnitExample1.java");
    }
}
