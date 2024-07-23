package chapters.five;

import static net.midview.Print.print;

public class Book {
    public String label;

    public Book(String label) {
        this.label = label;
    }

    public Book() {
        this("Книга без названия");
    }

    public String getLabel() {
        return label;
    }

    public static void main(String[] args) {
        Book book = new Book();
        Book thinkingInJava = new Book("Thinking in Java");

        print(book.getLabel());
        print(thinkingInJava.getLabel());
    }
}
