package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

public class Task5 {
    public static int count = 0;

    public int id = count++;

    public Task5() {
        System.out.println("Constructing AtUnitExample4 with id = " + id);
    }

    public String methodOne() {
        System.out.println("In methodOne() of AtUnitExample4 with id = " + id);
        return "This is method 1";
    }

    public int methodTwo() {
        System.out.println("In methodTwo() of AtUnitExample4 with id = " + id);
        System.out.println("This is method 2");
        return 2;
    }
}
