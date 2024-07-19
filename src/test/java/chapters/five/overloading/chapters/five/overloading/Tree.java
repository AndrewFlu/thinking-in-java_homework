package chapters.five.overloading.chapters.five.overloading;

/**
 * Описывает класс Дерево
 */
public class Tree {
    /**
     * Высота дерева
     */
    int height;

    /**
     * Конструктор для создания нового дерева из семени
     */
    public Tree() {
        print("Сажаем росток");
        height = 0;
    }

    /**
     * Конструктор для высаживания уже выращенного дерева
     * @param initialHeight высота саженца
     */
    public Tree(int initialHeight) {
        height = initialHeight;
        print("Высаживаем новое дерево высотой " +
                height + " м.");
    }

    /**
     * Выводит информацию о дереве
     */
    void info() {
        print("Дерево высотой " + height + " м.");
    }

    /**
     * Выводит информацию о дереве
     * @param s принимает тектовое описание
     */
    void info(String s) {
        print(s + ": Дерево высотой " + height + " м.");
    }

    /**
     * Утилитарный метод для печати в консоль
     * @param s строковый аргумент
     */
    private void print(String s) {
        System.out.println(s);
    }
}
