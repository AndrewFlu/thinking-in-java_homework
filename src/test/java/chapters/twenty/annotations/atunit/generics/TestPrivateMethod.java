package chapters.twenty.annotations.atunit.generics;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class TestPrivateMethod extends PrivateMethod {

    @Test
    void _hidden() {
        assert visible();
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.generics.TestPrivateMethod");
    }
}

class PrivateMethod {

    private boolean hidden() {
        return true;
    }

//    @TestProperty
    boolean visible() {
        return hidden();
    }
}
