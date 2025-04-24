package chapters.twenty.annotations.atunit.generics;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class StackListStringTest extends StackL<String> {
    @Test
    void _push() {
        push("one");
        assert top().equals("one");

        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");

        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void _top() {
        push("A");
        push("B");

        assert top().equals("B");
        assert top().equals("B");
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.generics.StackListStringTest");
    }
}
