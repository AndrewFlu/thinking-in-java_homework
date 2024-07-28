package chapters.seven.overloading;

public class Printer {
    void print(int number) {
        System.out.println("print(int number)");
    }

    void print(char ch) {
        System.out.println("print(char ch)");
    }

    void print(String str) {
        System.out.println("print(String str)");
    }

    protected final void printPdf() {
        System.out.println("Печать pdf-файла определена в Printer и не может быть изменена");
    }
}
