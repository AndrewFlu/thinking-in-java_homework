package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

import java.util.HashSet;

public class HashSetTest {
    HashSet<String> testObject = new HashSet<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        testObject.add("one");

        assert testObject.contains("one");
    }

    @Test
    void _remove() {
        testObject.add("one");
        testObject.remove("one");

        assert testObject.isEmpty();
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.HashSetTest");
    }
}
