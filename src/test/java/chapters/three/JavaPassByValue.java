package chapters.three;

public class JavaPassByValue {
    public static void main(String[] args) {
        Letter a = new Letter();
        a.symbol = 'a';
        Letter b = new Letter();
        b.symbol = 'b';

        System.out.printf("Letter a is %s%n", a.symbol);
        System.out.printf("Letter b is %s%n", b.symbol);

        System.out.println("Передадим Letter a в метод");
        changeValue(a);

        System.out.printf("Letter a is %s%n", a.symbol);
        System.out.printf("Letter b is %s%n", b.symbol);
    }

    private static void changeValue(Letter letter) {
        letter.symbol = 'c';
    }
}

class Letter {
    char symbol;
}
