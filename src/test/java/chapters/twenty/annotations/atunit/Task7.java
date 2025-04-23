package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

import java.util.LinkedList;

public class Task7 extends LinkedList<Integer> {

    @Test
    void initialization() {
        assert this.isEmpty();
    }

    @Test
    void _contains() {
        this.add(5);
        assert this.contains(5);
    }

    @Test
    void _remove() {
        this.add(1);
        this.remove(1);
        assert this.isEmpty();
    }

    @Test
    void _getFirst() {
        this.add(1);
        this.add(2);
        this.add(3);
        this.add(4);

        assert this.getFirst() == 1;
    }

    @Test
    void _getLast() {
        this.add(1);
        this.add(2);
        this.add(3);
        this.add(4);

        assert this.getFirst() == 4;
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.LinkedListTest");
    }
}
