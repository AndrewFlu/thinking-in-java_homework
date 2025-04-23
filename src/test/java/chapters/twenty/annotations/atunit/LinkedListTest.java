package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

import java.util.LinkedList;

public class LinkedListTest {
    LinkedList<Integer> testObject = new LinkedList<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        testObject.add(5);
        assert testObject.contains(5);
    }

    @Test
    void _remove() {
        testObject.add(1);
        testObject.remove(1);
        assert testObject.isEmpty();
    }

    @Test
    void _getFirst() {
        testObject.add(1);
        testObject.add(2);
        testObject.add(3);
        testObject.add(4);

        assert testObject.getFirst() == 1;
    }

    @Test
    void _getLast() {
        testObject.add(1);
        testObject.add(2);
        testObject.add(3);
        testObject.add(4);

        assert testObject.getFirst() == 4;
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.LinkedListTest");
    }
}
