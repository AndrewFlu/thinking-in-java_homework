package chapters.twenty.annotations.atunit;

import chapters.eighteen.input_optput.manageprocesses.OSExecute;
import chapters.twenty.annotations.base_syntax.Test;

import java.util.Objects;

public class Task10 {
    private String ident;

    public Task10(String ident) {
        this.ident = ident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task10 task10)) return false;
        return Objects.equals(ident, task10.ident);
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + ident);
    }

    //    @TestObjectCreate
    static Task10 create() {
        return new Task10("Hi");
    }

    @Test
    void _hashCode() {
        String s = "Hi";
        assert hashCode() == s.hashCode();
    }

    @Test
    void _equals() {
        Task10 testObject = new Task10("Hi");
        assert this.equals(testObject);
    }

    public static void main(String[] args) {
        OSExecute.command("java chapters.twenty.annotations.atunit.Task10");
    }
}

