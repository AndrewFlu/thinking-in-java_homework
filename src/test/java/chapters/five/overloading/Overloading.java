package chapters.five.overloading;

/**
 * Класс для запуска программы высаживания деревьев
 */
public class Overloading {
    /**
     * Точка входа в программу
     * @param args массив аргументов команднрой строки. Не используется
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree tree = new Tree(i);
            tree.info();
            tree.info("Перегруженный метод");
        }
        // Перегруженный конструктор
        new Tree();
    }
}
