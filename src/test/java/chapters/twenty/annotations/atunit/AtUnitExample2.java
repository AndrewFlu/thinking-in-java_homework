package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// В методах @Test могут использоваться команды assert и исключения
public class AtUnitExample2 {

    public String methodOne() {
        return "This is method 1";
    }

    public int methodTwo() {
        System.out.println("This is method 2");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is method 1");
    }

    @Test
    void assertFailureExample() {
        assert 1 == 2: "What a surprise!";
    }

    @Test
    void exceptionExample() throws FileNotFoundException {
        new FileInputStream("NoFile.txt"); // возбуждает исключение
    }

    @Test
    boolean assertAndReturn() {
        // Assert с сообщением
        assert methodTwo() == 2: "methowTwo must equal 2";
        return methodOne().equals("This is method 1");
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.AtUnitExample2");
    }
}
