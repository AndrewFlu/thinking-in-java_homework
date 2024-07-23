package chapters.five;

public class ThisLink {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print("Книга \"Игра престолов. Том 1\"");
    }

    private static class Printer {
        public void print(String s) {
            plainPrint(s);
            this.plainPrint(s);
        }

        private void plainPrint(String s) {
            System.out.println(s);
        }
    }
}
