package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;
import net.mindview.atunit.TestNote;

public class TestNoteTask11 {

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @TestNote(note = "methodOne should return a String ")
    @Test
    void _methodOne() {
        assert methodOne().equals("This is methodOne");
    }

    @TestNote(note = "methodTwo returns an Int")
    @Test
    void _methodTwo() {
        assert methodTwo() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.TestNoteTask11");
    }
}
