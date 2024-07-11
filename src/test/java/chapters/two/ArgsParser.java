package chapters.two;

public class ArgsParser {
    public static void main(String[] args) {
        System.out.println("Как тебя зовут?");
        String name = args[0];
        System.out.printf("Привет, %s!%n", name);
        System.out.println("Сколько тебе лет?");
        String age = args[1];
        System.out.printf("Ты отлично выглядишь в %s!%n", age);
        System.out.printf("Кстати, ты купишь себе BMW X%s%n", args[2]);
    }
}
